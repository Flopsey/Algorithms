package graph_algorithms;

public abstract class GraphUnweighted extends Graph {

    public GraphUnweighted(int n, boolean directed) {
        super(n, directed);
    }

    protected static void constructExampleGraph1(GraphUnweighted graph) {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);
    }

    static void constructExampleGraph2(GraphUnweighted graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(5, 3);
        graph.addEdge(6, 3);
        graph.addEdge(6, 5);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 7);
    }

    public void addEdge(int from, int to) {
        _addEdge(from, to);
        if (!directed) {
            _addEdge(to, from);
        }
        ++edgeCount;
    }

    protected abstract void _addEdge(int from, int to);

}
