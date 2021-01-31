package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;
import datastructures_for_dictionaries.LinkedListStack;
import datastructures_for_dictionaries.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        // Example:
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(7, true);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 0);
        graph.addEdge(4, 5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        System.out.println(topologicalSort(graph));  // [4, 5, 6, 3, 0, 1, 2]
    }

    public static LinkedList<Integer> topologicalSort(GraphUnweighted graph) {
        Stack<Integer> stack = new LinkedListStack<>();
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        LinkedList<Integer> topo = new LinkedList<>();
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
                    topo.addFirst(u);
                } else {
                    visited.addLast(u);
                    for (int v : graph.outEdges(u)) {
                        if (visited.contains(v)) {
                            continue;
                        }
                        stack.push(v);
                    }
                }
            }
        }
        return topo;
    }

}
