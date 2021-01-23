package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public class AdjacencyListUnweighted extends GraphUnweighted {

    public LinkedList<LinkedList<Integer>> adjacencyList;

    public AdjacencyListUnweighted(int n, boolean directed) {
        super(directed);
        adjacencyList = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.addLast(new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphUnweighted graph = new AdjacencyListUnweighted(4, false);
        constructExampleGraph(graph);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3

        // Directed
        GraphUnweighted digraph = new AdjacencyListUnweighted(4, true);
        constructExampleGraph(digraph);
        System.out.println(digraph.containsEdge(1, 3));  // false
        System.out.println(digraph.outEdges(3).size());  // 2
    }

    @Override
    public boolean containsEdge(int from, int to) {
        return adjacencyList.get(from).contains(to);
    }

    @Override
    public LinkedList<Integer> outEdges(int vertex) {
        return adjacencyList.get(vertex);
    }

    @Override
    protected void _addEdge(int from, int to) {
        LinkedList<Integer> out = adjacencyList.get(from);
        if (!out.contains(to)) {
            out.addLast(to);
        }
    }

}
