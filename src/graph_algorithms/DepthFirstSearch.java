package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;
import datastructures_for_dictionaries.LinkedListStack;
import datastructures_for_dictionaries.Stack;

public class DepthFirstSearch {

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
        depthFirstSearch(graph);
    }

    public static void depthFirstSearch(GraphUnweighted graph) {
        Stack<Integer> stack = new LinkedListStack<>();
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        int vertexCount = graph.getVertexCount();
        for (int s = 0; s < vertexCount; ++s) {
            if (visited.contains(s)) {
                continue;
            }
            stack.push(s);
            while (stack.top() != null) {
                int u = stack.top();
                if (visited.contains(u)) {
                    stack.pop();
                } else {
                    visited.addLast(u);
                    LinkedList<Integer> out = graph.outEdges(u);
                    for (int v : out) {
                        if (visited.contains(v)) {
                            continue;
                        }
                        stack.push(v);
                    }
                }
            }
        }
    }

}
