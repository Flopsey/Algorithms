package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public class AdjacencyListWeighted extends GraphWeighted {

    public LinkedList<LinkedList<Integer>> adjacencyList;
    public LinkedList<LinkedList<Double>> weights;

    public AdjacencyListWeighted(int n, boolean directed) {
        super(directed);
        adjacencyList = new LinkedList<>();
        weights = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.addLast(new LinkedList<>());
            weights.addLast(new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphWeighted graph = new AdjacencyListWeighted(4, false);
        constructExampleGraph(graph);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3

        // Directed
        GraphWeighted digraph = new AdjacencyListWeighted(4, true);
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
    protected void _addEdge(int from, int to, double cost) {
        LinkedList<Integer> out = adjacencyList.get(from);
        if (!out.contains(to)) {
            out.addLast(to);
            weights.get(from).addLast(cost);
        }
    }

}
