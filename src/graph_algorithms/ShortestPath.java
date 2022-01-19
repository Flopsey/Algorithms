package graph_algorithms;

import data_structures.LinkedList;

class ShortestPath {
    static LinkedList<Integer> backtrack(int[] predecessor, int from, int to) {
        LinkedList<Integer> shortestPath = new LinkedList<>();
        int v = to;
        while (v != from) {
            shortestPath.addFirst(v);
            v = predecessor[v];
        }
        shortestPath.addFirst(from);
        return shortestPath;
    }
}
