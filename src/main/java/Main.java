/** =====================================================================
 *
 *             -------------- VOICI MON PROJET -------------
 *
 *  NB : LA COMPILATION ET L'EXECUTION DU PROGRAMME PREND BEAUCOUPS PLUS DE TEMPS
 *
 *
 *
 *  =====================================================================
 */

import org.graphstream.algorithm.Toolkit;
import org.graphstream.graph.BreadthFirstIterator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceEdge;

import java.io.IOException;
import java.util.List;

public class Main {

    public String recuva = ""; // permet de recuperer les donnees a inserer dans les fichiers

    public String getRecuva() {
        return recuva;
    }

    public void setRecuva(String recuva) {
        this.recuva = recuva;
    }


    public static void main(String... args) { // Le main

        GenerateurGS_Reseau generateurGS_reseau = new GenerateurGS_Reseau();
        PropagationDansReseaux propagationDansReseaux = new PropagationDansReseaux();

        Main main = new Main();
        String filePath = "data/com-dblp.ungraph.txt";
        Graph graph = new SingleGraph("g");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        graph.addAttribute("ui.stylesheet","url('data/design.css')");

        FileSource fs = new FileSourceEdge();
        fs.addSink(graph);

        try {
            fs.readAll(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int taille = 100, degre = 3;
        Graph g_reseauAleatoire = generateurGS_reseau.generer_Aleatoire(taille, degre);
        //Graph g_BarabasiAlbert = generateurGS_reseau.generer_BarabasiAlbert(taille, degre);

//=====================> Queston 2


/*

        System.out.println("Noeud = " + graph.getNodeCount());
        System.out.println("Liens = " + graph.getEdgeCount());
        System.out.println("degré moyen = " + Toolkit.averageDegree(graph));
        System.out.println("coefficient de clustering DBLP : " + Toolkit.averageClusteringCoefficient(graph));
        System.out.println("coefficient de clustering pour un réseau aléatoire de la même taille et du même degré moyen est : " + Toolkit.averageClusteringCoefficient(generateurGS_reseau.generer_Aleatoire(graph.getNodeCount(), Toolkit.averageDegree(graph))));

        //=====================> Queston 3


        System.out.println("Le reseau DBLP" + ((Toolkit.isConnected(graph)) ? " est" : " n'est pas") + " connexe");
        System.out.println("Un réseau aléatoire de la même taille et degré moyen " + ((Toolkit.isConnected(generateurGS_reseau.generer_Aleatoire(graph.getNodeCount(), Toolkit.averageDegree(graph)))) ? " est" : "n'est pas") + " connexe");


        //=====================> Queston 5


        System.out.println("la distance moyenne dans DBLP = " + main.distancesReseau(graph, 1000));
        System.out.println("la distance moyenne dans le reseau aléatoire = " + Math.log(graph.getNodeCount())/Math.log(Toolkit.averageDegree(graph)));
*/

        //=====================> Queston 6

      /*  Graph g_reseauAleatoire = generateurGS_reseau.generer_Aleatoire(taille, degre);
        Graph g_BarabasiAlbert = generateurGS_reseau.generer_BarabasiAlbert(taille, degre);



        System.out.println("Noeud du reseau aleatoire = " + g_reseauAleatoire.getNodeCount());
        System.out.println("Noeud du reseau BarabasiAlbert = " + g_BarabasiAlbert.getNodeCount());

        System.out.println("Liens du reseau aleatoire = " + g_reseauAleatoire.getEdgeCount());
        System.out.println("Liens du reseau BarabasiAlbert = " + g_BarabasiAlbert.getEdgeCount());

        System.out.println("degré moyen du reseau aleatoire= " + Toolkit.averageDegree(g_reseauAleatoire));
        System.out.println("degré moyen du reseau BarabasiAlbert= " + Toolkit.averageDegree(g_BarabasiAlbert));

        System.out.println("coefficient de clustering du reseau aleatoire : " + Toolkit.averageClusteringCoefficient(g_reseauAleatoire));
        System.out.println("coefficient de clustering du reseau BarabasiAlbert : " + Toolkit.averageClusteringCoefficient(g_BarabasiAlbert));

        System.out.println("Le reseau aleatoire" + ((Toolkit.isConnected(g_reseauAleatoire)) ? " est" : " n'est pas") + " connexe");
        System.out.println("Le reseau BarabasiAlbert" + ((Toolkit.isConnected(g_BarabasiAlbert)) ? " est" : " n'est pas") + " connexe");

        System.out.println("la distance moyenne dans le reseau aléatoire = " + Math.log(g_reseauAleatoire.getNodeCount())/Math.log(Toolkit.averageDegree(g_reseauAleatoire)));
        System.out.println("la distance moyenne dans le reseau de BarabasiAlbert  = " + Math.log(g_BarabasiAlbert.getNodeCount())/Math.log(Math.log(g_BarabasiAlbert.getNodeCount())));

// Comparaison avec le reseau de collaboration

        System.out.println("la distance moyenne dans le reseau de BarabasiAlbert pour la comparaison  = " + Math.log(graph.getNodeCount())/Math.log(Math.log(graph.getNodeCount())));

        System.out.println("coefficient de clustering du reseau BarabasiAlbert pour la comparaison : " + Toolkit.averageClusteringCoefficient(generateurGS_reseau.generer_BarabasiAlbert(graph.getNodeCount(),Toolkit.averageDegree(graph))));
*/

        /** ==================================================================================
         *
         *  Les codes en commentaire ci-dessous permettent d'avoir des distributions de poisson
         *
         *  ==================================================================================
         */
//=====================> Queston 4
        int kcare = 0;
        int n = graph.getNodeCount();
        int[] dd = Toolkit.degreeDistribution(graph);
        for (int i = 0; i < dd.length; i++) {
            if (dd[i] > 0) {
                // System.out.printf("%6d %20f\n", i, (double) dd[i] / n);
                // main.setRecuva(main.getRecuva() + " \n" + i + " " + (double) dd[i] / n);
               // main.enregistreur("data/all_in_one");

                   // kcare += Math.pow(i,2)* ((double) dd[i] / n);

            }

        }

        //=============== TP PROPAGATION ================================================================================


       // Graph g_sameGraph =  generateurGS_reseau.generer_Aleatoire(graph.getNodeCount(),Toolkit.averageDegree(graph));
        //System.out.println("Taux de propagation (beta/mu) = "+ (1.0/7.0)/(1.0/14.0));
      //  System.out.println("Le seuil épidémique du réseau de collaboration = "+ Toolkit.averageDegree(graph)/propagationDansReseaux.kCare(graph));
        //System.out.println("Le seuil épidémique du réseau aleatoire = "+ Toolkit.averageDegree(g_sameGraph)/propagationDansReseaux.kCare(g_sameGraph));

        // J'AI COMMENTÉ POUR NE PAS TRAINÉ L'EXECUTION DU PROGRAMME


       /* propagationDansReseaux.sansInfection(graph);
        propagationDansReseaux.infecteUnNoeud(graph);
        propagationDansReseaux.propagerEpidemie(graph,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas1");

        propagationDansReseaux.reinitialisation();

        propagationDansReseaux.infecteUnNoeud(graph);
        propagationDansReseaux.immunisationAleatoire(graph);
        Graph gAlea = propagationDansReseaux.propagerEpidemie(graph,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas2");
        Graph gAleaNouveau = propagationDansReseaux.enleverInfecter(gAlea);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation aleatoire = "+ Toolkit.averageDegree(gAleaNouveau)/propagationDansReseaux.kCare(gAleaNouveau));

        propagationDansReseaux.reinitialisation();

*/
        propagationDansReseaux.infecteUnNoeud(graph);
        propagationDansReseaux.immunisationSelective(graph);
        Graph gSelect =  propagationDansReseaux.propagerEpidemie(graph,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas3");
        Graph gSelecNouveau = propagationDansReseaux.enleverInfecter(gSelect);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation seclective = "+ Toolkit.averageDegree(gSelecNouveau)/propagationDansReseaux.kCare(gSelecNouveau));

        //------------------------------------------------- Aleatoire ----------------------------------------------------------------------------------

         //Graph gAleatoire = generateurGS_reseau.generer_Aleatoire(graph.getNodeCount(), Toolkit.averageDegree(graph));
        //Graph gAlbert = generateurGS_reseau.generer_BarabasiAlbert(graph.getNodeCount(), Toolkit.averageDegree(graph));


       /* propagationDansReseaux.sansInfection(gAleatoire);
        propagationDansReseaux.infecteUnNoeud(gAleatoire);
        propagationDansReseaux.propagerEpidemie(gAleatoire,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas1Aleatoire");


        propagationDansReseaux.reinitialisation();

        propagationDansReseaux.infecteUnNoeud(gAleatoire);
        propagationDansReseaux.immunisationAleatoire(gAleatoire);
        Graph gAlea = propagationDansReseaux.propagerEpidemie(gAleatoire,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas2Aleatoire");
        Graph gAleaNouveau = propagationDansReseaux.enleverInfecter(gAlea);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation aleatoire = "+ Toolkit.averageDegree(gAleaNouveau)/propagationDansReseaux.kCare(gAleaNouveau));

        propagationDansReseaux.reinitialisation();


        /*propagationDansReseaux.infecteUnNoeud(gAleatoire);
        propagationDansReseaux.immunisationSelective(gAleatoire);
        Graph gSelect =  propagationDansReseaux.propagerEpidemie(gAleatoire,1.0/7.0,1.0/14.0);
         propagationDansReseaux.enregistreur("data/cas3Aleatoire");
        Graph gSelecNouveau = propagationDansReseaux.enleverInfecter(gSelect);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation seclective = "+ Toolkit.averageDegree(gSelecNouveau)/propagationDansReseaux.kCare(gSelecNouveau));
*/

       //-------------------------------------------- Barabassi Albert---------------------------------------------------------------------------------------


/*
        propagationDansReseaux.sansInfection(gAlbert);
        propagationDansReseaux.infecteUnNoeud(gAlbert);
        propagationDansReseaux.propagerEpidemie(gAlbert,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas1Albert");


        propagationDansReseaux.reinitialisation();


        propagationDansReseaux.infecteUnNoeud(gAlbert);
        propagationDansReseaux.immunisationAleatoire(gAlbert);
        Graph gAlea = propagationDansReseaux.propagerEpidemie(gAlbert,1.0/7.0,1.0/14.0);
        propagationDansReseaux.enregistreur("data/cas2Albert");
        Graph gAleaNouveau = propagationDansReseaux.enleverInfecter(gAlea);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation aleatoire = "+ Toolkit.averageDegree(gAleaNouveau)/propagationDansReseaux.kCare(gAleaNouveau));

        propagationDansReseaux.reinitialisation();



        propagationDansReseaux.infecteUnNoeud(gAlbert);
        propagationDansReseaux.immunisationSelective(gAlbert);
        Graph gSelect =  propagationDansReseaux.propagerEpidemie(gAlbert,1.0/7.0,1.0/14.0);
         propagationDansReseaux.enregistreur("data/cas3Albert");
        Graph gSelecNouveau = propagationDansReseaux.enleverInfecter(gSelect);
        System.out.println("Le seuil épidémique du réseau avec stratégies d'immunisation seclective = "+ Toolkit.averageDegree(gSelecNouveau)/propagationDansReseaux.kCare(gSelecNouveau));


*/
        //=============== Fin PROPAGATION ================================================================================




       /* main.setRecuva("");

        for (int i = 0; i < dd.length; i++) {
            if (dd[i] != 0) {
                  System.out.printf("%6d%20.8f%n", i, (double) dd[i] / graph.getNodeCount());
                  main.setRecuva(main.getRecuva() + " \n" + i + " " + (double) dd[i] / n);
                  main.enregistreur("data/file_distributionDegrees");


            }
        }

        main.setRecuva("");

        for (int i = 0; i < dd.length; i++) {
            if (dd[i] != 0) {
                System.out.printf("%6d%20.8f%n", i, (double) dd[i] / g_BarabasiAlbert.getNodeCount());
                main.setRecuva(main.getRecuva() + " \n" + i + " " + (double) dd[i] / n);
                main.enregistreur("data/file_distributionDegreesBarabasiAlbert");


            }
        }

        main.setRecuva("");

        for (int i = 0; i < dd.length; i++) {
            if (dd[i] != 0) {
                System.out.printf("%6d%20.8f%n", i, (double) dd[i] / g_reseauAleatoire.getNodeCount());
                main.setRecuva(main.getRecuva() + " \n" + i + " " + (double) dd[i] / n);
                main.enregistreur("data/file_distributionDegreesAleatoire");


            }
        }


        g_reseauAleatoire.display(); //visualisation du reseau aleatoire
        g_BarabasiAlbert.display();  //visualisation du reseau BarabasiAlbert
        graph.display();  //visualisation du reseau de collaboration
*/
        //=====================> Queston 7

         // System.out.println("Coeficient de clustering =  " +Toolkit.averageClusteringCoefficient(  new MonGraphe().question7(100, 4, 0.9))); // coef de clostering
         // main.distancesReseau(g_reseauAleatoire,100);
         //main.distancesReseau(g_reseauAleatoire,100);


    }

//=====================> Fonction d'enregistrement dans les fichiers
/*
    public void enregistreur(String nom_fichier) { // methode d'enregistrement dans les fichiers
        try {
            PrintWriter printWriter = new PrintWriter(nom_fichier, "UTF-8");

            printWriter.write(getRecuva());
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }*/

    //=====================> Queston 5 (Distance)


    private double distancesReseau(Graph graph, int taille) { // la methode de generation de distance du reseau de collaboration
        setRecuva("");
        List<Node> sources = Toolkit.randomNodeSet(graph, taille);
        long[] dd = new long[50];
        sources.forEach(source -> {
            BreadthFirstIterator<Node> bf = new BreadthFirstIterator<>(source);
            while (bf.hasNext()) {
                Node v = bf.next();
                dd[bf.getDepthOf(v)]++;
            }
        });
        double dAvg = 0;
        for (int d = 0; d < dd.length; d++) {
            if (dd[d] > 0) {
                double pd = (double) dd[d] / (taille * graph.getNodeCount());
                dAvg += d * pd;


                setRecuva(getRecuva() + " \n" + d + " " + pd);
              //  enregistreur("data/file_distributionDistance");
               // enregistreur("data/file_distributionDistanceBarabasiAlbert");
               // enregistreur("data/file_distributionDistanceAleatoire");

            }
        }

        return dAvg;
    }



}
