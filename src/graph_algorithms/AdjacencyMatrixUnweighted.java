package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public class AdjacencyMatrixUnweighted extends GraphUnweighted {

    public boolean[][] adjacencyMatrix;

    public AdjacencyMatrixUnweighted(int n, boolean directed) {
        super(directed);
        adjacencyMatrix = new boolean[n][n];
    }

    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphUnweighted graph = new AdjacencyMatrixUnweighted(4, false);
        constructExampleGraph(graph);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3

        // Directed
        GraphUnweighted digraph = new AdjacencyMatrixUnweighted(4, true);
        constructExampleGraph(digraph);
        System.out.println(digraph.containsEdge(1, 3));  // false
        System.out.println(digraph.outEdges(3).size());  // 2
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