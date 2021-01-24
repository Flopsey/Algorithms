package graph_algorithms;

import datastructures_for_dictionaries.*;

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
        System.out.println(topologicalSort(graph));  // []
    }

    public static LinkedList<Integer> topologicalSort(GraphUnweighted graph) {
        Stack<Integer> stack = new LinkedListStack<>();
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        int vertexCount = graph.getVertexCount();
        Heap<PriorityQueue.KeyValuePair<Integer>> post = new Heap<>();
        int t = 0;
        for (int s = 0; s < vertexCount; ++s) {
            if (visited.contains(s)) {
                continue;
            }
            stack.push(s);
            while (stack.top() != null) {
                int u = stack.top();
                if (visited.contains(u)) {
                    stack.pop();
                    if (post.contains(u)) {
                        post.decreaseKey(u, t--);
                    } else {
                        post.insert(new PriorityQueue.KeyValuePair<>(u, t++));
                    }
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
        LinkedList<Integer> topo = new LinkedList<>();
        while (post.getMin() != null) {
            topo.addFirst(post.extractMin().value);
        }
        return topo;
    }

}
