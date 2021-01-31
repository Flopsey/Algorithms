package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public class AdjacencyMatrixWeighted extends GraphWeighted {

    public double[][] adjacencyMatrix;

    public AdjacencyMatrixWeighted(int n, boolean directed) {
        super(n, directed);
        adjacencyMatrix = new double[n][n];
        for (int from = 0; from < adjacencyMatrix.length; ++from) {
            for (int to = 0; to < adjacencyMatrix[from].length; ++to) {
                adjacencyMatrix[from][to] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphWeighted graph = new AdjacencyMatrixWeighted(4, false);
        constructExampleGraph(graph);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3
        System.out.println(graph.getVertexCount());  // 4
        System.out.println(graph.getEdgeCount());  // 5

        // Directed
        GraphWeighted digraph = new AdjacencyMatrixWeighted(4, true);
        constructExampleGraph(digraph);
        System.out.println(digraph.containsEdge(1, 3));  // false
        System.out.println(digraph.outEdges(3).size());  // 2
        System.out.println(digraph.getVertexCount());  // 4
        System.out.println(digraph.getEdgeCount());  // 5
    }

    @Override
    public boolean containsEdge(int from, int to) {
        return adjacencyMatrix[from][to] != Double.POSITIVE_INFINITY;
    }

    @Override
    public LinkedList<Integer> outEdges(int vertex) {
        LinkedList<Integer> out = new LinkedList<>();
        for (int to = 0; to < adjacencyMatrix[vertex].length; ++to) {
            if (containsEdge(vertex, to)) {
                out.addLast(to);
            }
        }
        return out;
    }

    @Override
    protected void _addEdge(int from, int to, double cost) {
        adjacencyMatrix[from][to] = cost;
    }

    @Override
    public double cost(int from, int to) {
        return adjacencyMatrix[from][to];
    }

}
