package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

public abstract class Graph {

    protected boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public abstract boolean containsEdge(int from, int to);

    public abstract LinkedList<Integer> outEdges(int vertex);

}
