package graph_algorithms;

import data_structures.*;

public class Prim {

    public static void main(String[] args) {
        Graph graph = new AdjacencyListGraph(4, false);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 3);
        Graph mst = prim(graph);
        System.out.println(mst.edgeCount);  // 3
        // TODO: Additional tests
    }

    public static Graph prim(Graph graph) {
        Graph mst = new AdjacencyListGraph(graph.getVertexCount(), graph.directed);

        int vertexCount = graph.getVertexCount();
        double[] minCost = new double[vertexCount];
        Graph.Edge[] minCostEdge = new Graph.Edge[vertexCount];
        for (int i = 0; i < vertexCount; ++i) {
            minCost[i] = Double.POSITIVE_INFINITY;
        }
        minCost[0] = 0;
        LinkedList<Integer> visited = new LinkedList<>();  // TODO: Use Dictionary once AVLTree is finished
        KeyedPriorityQueue<Integer> prioQueue = new KeyedHeap<>();
        for (int i = 0; i < graph.getVertexCount(); ++i) {
            prioQueue.insert(i, minCost[i]);
        }

        while (visited.size() != vertexCount) {
            int u = prioQueue.extractMin();
            visited.addLast(u);
            if (minCostEdge[u] != null) {
                mst.addEdge(minCostEdge[u].from, minCostEdge[u].to, minCost[u]);
            }
            for (int v : graph.outEdges(u)) {
                if (visited.contains(v)) {
                    continue;
                }
                double d1 = minCost[v];
                double d2 = graph.cost(u, v);
                if (d2 < d1) {
                    minCost[v] = d2;
                    prioQueue.decreaseKey(v, d2);
                    minCostEdge[v] = new Graph.Edge(u, v);
                }
            }
        }

        return mst;
    }

}
