import org.graphstream.algorithm.Toolkit;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class PropagationDansReseaux {

    String recuva;

    public  String getRecuva() {
        return recuva;
    }

    public  void setRecuva(String recuva) {
        this.recuva = recuva;
    }

    private static final String I = "I";

    public static int date = 84;
    public static HashSet<Node> desinfecte = new HashSet<>();
    public static HashSet<Node> infectees = new HashSet<>();

    public static double kCare(Graph g) {//degree de Variance
        int sum = 0;
        for (Node x : g) sum += Math.pow(x.getDegree(), 2);
        return sum / (double) g.getNodeCount();
    }



    public  Node randomNode(Graph graph) {

        return Toolkit.randomNode(graph);
    }

    public void sansInfection(Graph graph){
        for (Node n : graph.getNodeSet()) {
            n.addAttribute("virus_state","initialiser");
        }
    }

    public void infecteUnNoeud(Graph g) {
        infecter(randomNode(g));
    }

    public static void infecter(Node n) {
        n.setAttribute("virus_state", "infecter");
        infectees.add(n);
    }



    public static void desinfecter(Node n) {
        n.setAttribute("virus_state", "initialiser");
        desinfecte.add(n);

    }

    public static void reinitialisation() {
        infectees.clear();
        desinfecte.clear();
    }

    public static void immunisationAleatoire(Graph g) {
        desinfecte = new HashSet<>(Toolkit.randomNodeSet(g, g.getNodeCount() / 2));

        for (Node n : desinfecte) {
            desinfecter(n);
        }

    }



    public Graph propagerEpidemie(Graph g, double beta, double mu) {
        setRecuva("");

        ArrayList<Node> desinfecter = new ArrayList<>();
        ArrayList<Node> infecter = new ArrayList<>();

        int Size = g.getNodeCount();
        int immuneNumber = desinfecte.size();

        for(int i = 0 ; i < date ; i++) {
            for (Node n : infectees) {
                Iterator<Node> iter = n.getNeighborNodeIterator();

                while(iter.hasNext()) {
                    Node voisin = iter.next();

                    if(voisin.getAttribute("virus_state") == "initialiser") {

                        if(Math.random()< beta)
                            infecter.add(voisin);
                    }
                }

                if(Math.random() < mu)
                    desinfecter.add(n);
            }

            for (Node n : desinfecter)
                desinfecter(n);
               desinfecter.clear();

            for (Node n : infecter) {
                infecter(n);

            }
                System.out.printf("\njour %d/%d : %d/%d infectés\n ", i, date, infectees.size(), (Size - immuneNumber));



            setRecuva(getRecuva() + "\n" + i+"  "+((double) infectees.size()));

        }
        return g;
    }
    public static void immunisationSelective(Graph g) {
        ArrayList<Node> desinfectionList = (ArrayList<Node>)Toolkit.randomNodeSet(g, g.getNodeCount() / 2);

        double groupe0 = 0, groupe1 = 0;
        double degMoy0 = 0;
        double degMoy1 = 0;
        Random random = new Random();

        for (Node n : desinfectionList) {
            Iterator<Node> iter = n.getNeighborNodeIterator();
            ArrayList<Node> neighbors = new ArrayList<>();

            while(iter.hasNext())
                neighbors.add(iter.next());

            int unVoisin = (int)Math.floor(Math.random()*neighbors.size());
            desinfecter(neighbors.get(unVoisin));

            degMoy0 += n.getDegree();
            groupe0++;
            int ind_noeud_Selec = random.nextInt(n.getDegree());
            Node Voisin = n.getEdge(ind_noeud_Selec).getOpposite(n);

            desinfecte.add(Voisin);
            Voisin.addAttribute("etat", "immunise");

            degMoy1 += Voisin.getDegree();
            groupe1++;
        }

        degMoy0 = degMoy0 /  (g.getNodeCount() / 2);
        degMoy1 = degMoy1 /  (g.getNodeCount() / 2);

        System.out.println("\ndegré moyen du groupe 0 = " + degMoy0);
        System.out.println("\ndegré moyen du groupe 1 = " + degMoy1);

    }



    public static Graph enleverInfecter(Graph g) {
        for(Node n : infectees) {
            g.removeNode(n);
        }

        return g;
    }





    public void enregistreur(String file_binomial) {
        try {
            PrintWriter printWriter = new PrintWriter(file_binomial, "UTF-8");
            printWriter.write(getRecuva());
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}
