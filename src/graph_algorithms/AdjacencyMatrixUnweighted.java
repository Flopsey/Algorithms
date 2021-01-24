package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public class AdjacencyMatrixUnweighted extends GraphUnweighted {

    public boolean[][] adjacencyMatrix;

    public AdjacencyMatrixUnweighted(int n, boolean directed) {
        super(n, directed);
        adjacencyMatrix = new boolean[n][n];
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(4, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3
        System.out.println(graph.getVertexCount());  // 4
        System.out.println(graph.getEdgeCount());  // 5

        // Directed
        GraphUnweighted digraph = new AdjacencyMatrixUnweighted(4, true);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);
        System.out.println(digraph.containsEdge(1, 3));  // false
        System.out.println(digraph.outEdges(3).size());  // 2
        System.out.println(digraph.getVertexCount());  // 4
        System.out.println(digraph.getEdgeCount());  // 5
    }

    @Override
    public boolean containsEdge(int from, int to) {
        return adjacencyMatrix[from][to];
    }

    @Override
    public LinkedList<Integer> outEdges(int vertex) {
        LinkedList<Integer> out = new LinkedList<>();
        for (int to = 0; to < adjacencyMatrix[vertex].length; ++to) {
            if (adjacencyMatrix[vertex][to]) {
                out.addLast(to);
            }
        }
        return out;
    }

    @Override
    protected void _addEdge(int from, int to) {
        adjacencyMatrix[from][to] = true;
    }

}
