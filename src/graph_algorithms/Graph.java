package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public abstract class Graph {

    protected final int vertexCount;
    protected boolean directed;
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

    public abstract boolean containsEdge(int from, int to);

    public abstract LinkedList<Integer> outEdges(int vertex);

}
