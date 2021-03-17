package graphs;

public abstract class GraphWeighted extends Graph {

    public GraphWeighted(int n, boolean directed) {
        super(n, directed);
    }

    protected static void constructExampleGraph(GraphWeighted graph) {
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 0, 5);
    }

    public void addEdge(int from, int to, double cost) {
        _addEdge(from, to, cost);
        if (!directed) {
            _addEdge(to, from, cost);
        }
        edgeCount++;
    }

    protected abstract void _addEdge(int from, int to, double cost);

    public abstract double cost(int from, int to);

}

class NegativeCycleException extends IllegalArgumentException {
}
