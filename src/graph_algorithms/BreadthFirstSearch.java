package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;
import datastructures_for_dictionaries.LinkedListQueue;
import datastructures_for_dictionaries.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        // Example:
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(10, true);
        GraphUnweighted.constructExampleGraph2(graph);
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
                    LinkedList<Integer> out = graph.outEdges(u);
                    for (int v : out) {
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
