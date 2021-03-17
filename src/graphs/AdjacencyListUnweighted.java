package graphs;

import data_structures.LinkedList;

public class AdjacencyListUnweighted extends GraphUnweighted {

    public LinkedList<LinkedList<Integer>> adjacencyList;

    public AdjacencyListUnweighted(int n, boolean directed) {
        super(n, directed);
        adjacencyList = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            adjacencyList.addLast(new LinkedList<>());
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Examples:

        // Undirected
        GraphUnweighted graph = new AdjacencyListUnweighted(4, false);
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
        GraphUnweighted digraph = new AdjacencyListUnweighted(4, true);
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
