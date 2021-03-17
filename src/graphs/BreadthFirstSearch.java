package graphs;

import data_structures.LinkedList;
import data_structures.LinkedListQueue;
import data_structures.Queue;

public class BreadthFirstSearch {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Example:
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(10, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(5, 3);
        graph.addEdge(6, 3);
        graph.addEdge(6, 5);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 7);
        breadthFirstSearch(graph);
    }

    public static void breadthFirstSearch(GraphUnweighted graph) {
        Queue<Integer> queue = new LinkedListQueue<>();
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        int vertexCount = graph.getVertexCount();
        for (int s = 0; s < vertexCount; ++s) {
            if (visited.contains(s)) {
                continue;
            }
            queue.enqueue(s);
            while (queue.front() != null) {
                int u = queue.dequeue();
                if (!visited.contains(u)) {
                    visited.addLast(u);
                    for (int v : graph.outEdges(u)) {
                        if (visited.contains(v)) {
                            continue;
                        }
                        queue.enqueue(v);
                    }
                }
            }
        }
    }

}
