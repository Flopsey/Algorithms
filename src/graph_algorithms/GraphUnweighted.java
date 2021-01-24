package graph_algorithms;

public abstract class GraphUnweighted extends Graph {

    public GraphUnweighted(int n, boolean directed) {
        super(n, directed);
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
