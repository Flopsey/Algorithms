package graph_algorithms;

import data_structures.LinkedList;

public class BellmanFord extends ShortestPath {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Example:
        Graph graph = new AdjacencyListGraph(6, true);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, -1);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 3, -4);
        graph.addEdge(3, 1, 8);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 3);
        System.out.println(bellmanFord(graph, 0, 5));  // [0, 1, 2, 3, 4, 5]
    }

    public static LinkedList<Integer> bellmanFord(Graph graph, int from, int to) {
        double[] distance = new double[graph.getVertexCount()];
        int[] predecessor = new int[graph.getVertexCount()];
        for (int i = 0; i < graph.getVertexCount(); ++i) {
            distance[i] = Double.POSITIVE_INFINITY;
        }
        distance[from] = 0;

        for (int i = 0; i < graph.getVertexCount(); ++i) {
            graph.forEachEdge((Integer u, Integer v) -> {
                double d1 = distance[v];
                double d2 = distance[u] + graph.cost(u, v);
                if (d2 < d1) {
                    distance[v] = d2;
                    predecessor[v] = u;
                }
            });
        }

        graph.forEachEdge((Integer u, Integer v) -> {
            if (distance[v] > distance[u] + graph.cost(u, v)) {
                throw new NegativeCycleException();
            }
        });

        return ShortestPath.backtrack(predecessor, from, to);
    }

}
