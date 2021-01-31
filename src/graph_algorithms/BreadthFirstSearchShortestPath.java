package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;
import datastructures_for_dictionaries.LinkedListQueue;
import datastructures_for_dictionaries.Queue;

public class BreadthFirstSearchShortestPath extends ShortestPath {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Example:
        GraphUnweighted graph = new AdjacencyListUnweighted(9, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 0);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(4, 8);
        graph.addEdge(6, 3);
        graph.addEdge(7, 3);
        graph.addEdge(7, 8);
        System.out.println(breadthFirstSearchShortestPath(graph, 0, 7));  // [0, 1, 4, 7]
    }

    public static LinkedList<Integer> breadthFirstSearchShortestPath(GraphUnweighted graph, int from, int to) {
        Queue<Integer> queue = new LinkedListQueue<>();
        int vertexCount = graph.getVertexCount();
        int[] distance = new int[vertexCount];
        int[] predecessor = new int[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[from] = 0;
        queue.enqueue(from);

        outer:
        while (queue.front() != null) {
            int u = queue.dequeue();
            for (int v : graph.outEdges(u)) {
                if (distance[v] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.enqueue(v);
                distance[v] = distance[u] + 1;
                predecessor[v] = u;
                if (v == to) {
                    break outer;
                }
            }
        }

        return backtrack(predecessor, from, to);
    }

}
