package dynamic_programming;

import datastructures_for_dictionaries.LinkedList;
import search_sort.BinarySearch;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // Example:
        int[] sequence = {4, 9, 8, 13, 10, 11, 7, 3, 16};
        System.out.println(longestIncreasingSubsequence(sequence));  // [4, 8, 10, 11, 16]
    }

    public static LinkedList<Integer> longestIncreasingSubsequence(int[] sequence) {
        int[] table = new int[sequence.length + 1];
        int[] predecessors = new int[sequence.length];
        table[0] = Integer.MIN_VALUE;
        for (int i = 1; i < table.length; ++i) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < sequence.length; ++i) {
            int l = BinarySearch.binarySearchIterative(table, sequence[i]);
            if (l < 0) {
                l = -l - 1;
            }
            table[l] = sequence[i];
            predecessors[i] = table[l - 1];
        }

        LinkedList<Integer> solution = new LinkedList<>();
        int iLast = table.length - 1;
        while (table[iLast] == Integer.MAX_VALUE) {
            --iLast;
        }
        int element = table[iLast];
        while (element > Integer.MIN_VALUE) {
            solution.addFirst(element);
            int i = sequence.length - 1;
            while (sequence[i] != element) {
                --i;
            }
            element = predecessors[i];
        }
        return solution;
    }

}
