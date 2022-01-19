package graph_algorithms;

import data_structures.LinkedList;

import java.util.function.BiConsumer;

public abstract class Graph {

    protected final int vertexCount;
    protected final boolean directed;
    protected int edgeCount = 0;

    public Graph(int n, boolean directed) {
        vertexCount = n;
        this.directed = directed;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, double cost) {
        _addEdge(from, to, cost);
        if (!directed) {
            _addEdge(to, from, cost);
        }
        edgeCount++;
    }

    protected abstract void _addEdge(int from, int to, double cost);

    public abstract boolean containsEdge(int from, int to);

    public abstract LinkedList<Integer> outEdges(int vertex);  // TODO: Use Dictionary once AVLTree is finished

    public void forEachEdge(BiConsumer<Integer, Integer> action) {
        for (int u = 0; u < vertexCount; ++u) {
            for (int v : this.outEdges(u)) {
                action.accept(u, v);
            }
        }
    }

    public abstract double cost(int from, int to);

    protected static void constructExampleGraph(Graph graph) {
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 0, 5);
    }

}
