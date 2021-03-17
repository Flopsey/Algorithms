package graphs;

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

    public abstract boolean containsEdge(int from, int to);

    public abstract LinkedList<Integer> outEdges(int vertex);  // TODO: Use Dictionary once AVLTree is finished

    public void forEachEdge(BiConsumer<Integer, Integer> action) {
        if (directed) {
            for (int u = 0; u < vertexCount; ++u) {
                for (int v : this.outEdges(u)) {
                    action.accept(u, v);
                }
            }
        } else {
            LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
            for (int u = 0; u < vertexCount; ++u) {
                if (visited.contains(u)) {
                    continue;
                }
                visited.addLast(u);
                for (int v : this.outEdges(u)) {
                    if (visited.contains(v)) {
                        continue;
                    }
                    visited.addLast(v);
                    action.accept(u, v);
                }
            }
        }
    }

}
