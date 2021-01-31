package graph_algorithms;

import datastructures_for_dictionaries.KeyedHeap;
import datastructures_for_dictionaries.KeyedPriorityQueue;
import datastructures_for_dictionaries.LinkedList;

public class Dijkstra extends ShortestPath {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Example:
        GraphWeighted graph = new AdjacencyListWeighted(9, true);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 0, 8);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 6, 6);
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(4, 8, 5);
        graph.addEdge(6, 3, 5);
        graph.addEdge(7, 3, 2);
        graph.addEdge(7, 8, 3);
        System.out.println(dijkstra(graph, 0, 7));  // [0, 1, 3, 4, 7]
    }

    public static LinkedList<Integer> dijkstra(GraphWeighted graph, int from, int to) {
        int vertexCount = graph.getVertexCount();
        double[] distance = new double[vertexCount];
        int[] predecessor = new int[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            distance[i] = Double.POSITIVE_INFINITY;
        }
        distance[from] = 0;
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        KeyedPriorityQueue<Integer> prioQueue = new KeyedHeap<>();
        for (int i = 0; i < graph.getVertexCount(); ++i) {
            prioQueue.insert(i, distance[i]);
        }

        while (visited.size() != vertexCount) {
            int u = prioQueue.extractMin();
            visited.addLast(u);
            for (int v : graph.outEdges(u)) {
                if (visited.contains(v)) {
                    continue;
                }
                double d1 = distance[v];
                double d2 = distance[u] + graph.cost(u, v);
                if (d2 < d1) {
                    distance[v] = d2;
                    prioQueue.decreaseKey(v, d2);
                    predecessor[v] = u;
                }
            }
        }

        return backtrack(predecessor, from, to);
    }

}
