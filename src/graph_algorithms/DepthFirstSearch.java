package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;
import datastructures_for_dictionaries.LinkedListStack;
import datastructures_for_dictionaries.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        // Example:
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(10, true);
        GraphUnweighted.constructExampleGraph2(graph);
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
