package graphs;

import data_structures.LinkedList;

public class AdjacencyListWeighted extends GraphWeighted {

    public LinkedList<LinkedList<Integer>> adjacencyList;
    public LinkedList<LinkedList<Double>> weights;

    public AdjacencyListWeighted(int n, boolean directed) {
        super(n, directed);
        adjacencyList = new LinkedList<>();
        weights = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.addLast(new LinkedList<>());
            weights.addLast(new LinkedList<>());
            addEdge(i, i, 0);
        }
    }

    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphWeighted graph = new AdjacencyListWeighted(4, false);
        constructExampleGraph(graph);
        System.out.println(graph.containsEdge(1, 3));  // true
        System.out.println(graph.outEdges(3).size());  // 3
        System.out.println(graph.getVertexCount());  // 4
        System.out.println(graph.getEdgeCount());  // 5

        // Directed
        GraphWeighted digraph = new AdjacencyListWeighted(4, true);
        constructExampleGraph(digraph);
        System.out.println(digraph.containsEdge(1, 3));  // false
        System.out.println(digraph.outEdges(3).size());  // 2
        System.out.println(digraph.getVertexCount());  // 4
        System.out.println(digraph.getEdgeCount());  // 5
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

    @Override
    public double cost(int from, int to) {
        LinkedList<Integer> out = adjacencyList.get(from);
        int index = out.indexOf(to);
        if (index == -1) {
            return Double.POSITIVE_INFINITY;
        }
        return weights.get(from).get(index);
    }

}
