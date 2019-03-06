
/** =====================================================================
 *
 *             --------------Question 6 ----------
 *
 *  =====================================================================
 */


import org.graphstream.algorithm.generator.BarabasiAlbertGenerator;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class GenerateurGS_Reseau {
    Main main = new Main();

    public Graph generer_Aleatoire(int taille, double degre) { // methode de generation du reseau aleatoire

        Graph graph = new SingleGraph("Aleatoire");
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        Generator gen = new RandomGenerator(degre);
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < taille; i++)
            gen.nextEvents();
        gen.end();
        return graph;
    }


    public Graph generer_BarabasiAlbert(int taille, double degre) { //methode de generation du reseau BarabasiAlbert

        Graph graph = new SingleGraph("Barabàsi-Albert");
        Generator gen = new BarabasiAlbertGenerator((int) degre);
        gen.addSink(graph);
        gen.begin();

        for (int i = 0; i < taille; i++) {
            gen.nextEvents();
        }

        gen.end();
        return graph;

    }
}