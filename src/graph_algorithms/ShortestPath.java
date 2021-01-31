package graph_algorithms;

import datastructures_for_dictionaries.LinkedList;

class ShortestPath {
    static LinkedList<Integer> shortestPathBacktrack(int[] predecessor, int from, int to) {
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
