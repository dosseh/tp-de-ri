

/** =====================================================================
 *
 *             --------------Question 7 ----------
 *
 *  =====================================================================
 */


import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.WattsStrogatzGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;


public class MonGraphe {

    public Graph question7(int node, int degre, double proba) { //new MonGraphe().question7(100, 4, 0.9);


        Graph graph = new SingleGraph("graph");

        // n est le nombre de sommet, 4 le nombre de degree moyen et beta la probabilité

        Generator gen = new WattsStrogatzGenerator(node,degre,proba);

        gen.addSink(graph);
        gen.begin();
        while (gen.nextEvents()) {
        }
        gen.end();

        graph.display(false);
        return graph;
    }
}
