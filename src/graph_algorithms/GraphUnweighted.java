package graph_algorithms;

public abstract class GraphUnweighted extends Graph {

    public GraphUnweighted(boolean directed) {
        super(directed);
    }

    protected static void constructExampleGraph(GraphUnweighted graph) {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);
    }

    public void addEdge(int from, int to) {
        _addEdge(from, to);
        if (!directed) {
            _addEdge(to, from);
        }
    }

    protected abstract void _addEdge(int from, int to);

}
