package graph_algorithms;

public class FloydWarshall extends ShortestPath {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        // Example:
        GraphWeighted graph = new AdjacencyListWeighted(6, true);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, -1);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 3, -4);
        graph.addEdge(3, 1, 8);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 3);
        System.out.println(java.util.Arrays.deepToString(floydWarshall(graph)));  // TODO: Verify that the output is correct
        System.out.println(java.util.Arrays.deepToString(transitiveClosure(graph)));  // TODO: Verify that the output is correct
    }

    public static double[][] floydWarshall(GraphWeighted graph) {
        int n = graph.getVertexCount();
        double[][][] table = new double[n + 1][n][n];
        for (int u = 0; u < n; ++u) {
            table[0][u][u] = 0;
        }
        for (int u = 0; u < n; ++u) {
            for (int v = 0; v < n; ++v) {
                table[0][u][v] = graph.cost(u, v);
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int u = 0; u < n; ++u) {
                for (int v = 0; v < n; ++v) {
                    double d1 = table[i - 1][u][v];
                    double d2 = table[i - 1][u][i] + table[i - 1][i][v];
                    if (u == v && Math.min(d1, d2) != 0) {
                        throw new NegativeCycleException();
                    }
                    table[i][u][v] = Math.min(d2, d1);
                }
            }
        }

        return table[n - 1];  // TODO: Compute actual shortest paths, not just their lengths
    }

    public static boolean[][] transitiveClosure(GraphWeighted graph) {
        int n = graph.getVertexCount();
        boolean[][][] table = new boolean[n + 1][n][n];
        for (int u = 0; u < n; ++u) {
            table[0][u][u] = true;
        }
        for (int u = 0; u < n; ++u) {
            for (int v = 0; v < n; ++v) {
                table[0][u][v] = graph.outEdges(u).contains(v);
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int u = 0; u < n; ++u) {
                for (int v = 0; v < n; ++v) {
                    table[i][u][v] = table[i - 1][u][v] || (table[i - 1][u][i] && table[i - 1][i][v]);
                }
            }
        }

        return table[n - 1];
    }

}
