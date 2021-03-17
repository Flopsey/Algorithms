package dynamic_programming;

import data_structures.LinkedList;

public class SubsetSum {

    public static void main(String[] args) {
        // Example:
        System.out.println(subsetSum(new int[]{5, 3, 7, 3, 1}, 9));  // [5, 3, 1] (not a unique solution)
    }

    public static LinkedList<Integer> subsetSum(int[] values, int targetValue) {
        boolean[][] table = new boolean[values.length + 1][targetValue + 1];
        table[0][0] = true;
        for (int j = 1; j < targetValue + 1; ++j) {
            table[0][j] = false;
        }

        for (int i = 1; i < values.length + 1; ++i) {
            for (int s = 0; s < targetValue + 1; ++s) {
                boolean newValue = table[i - 1][s];
                if (s - values[i - 1] >= 0) {
                    newValue = newValue || table[i - 1][s - values[i - 1]];
                }
                table[i][s] = newValue;
            }
        }

        LinkedList<Integer> solution = new LinkedList<>();
        int i = values.length;
        int s = targetValue;
        while (i != 0 && s != 0) {
            if (i - 1 >= 0 && !table[i - 1][s]) {
                s -= values[i - 1];
                solution.addFirst(values[i - 1]);
            }
            --i;
        }
        return solution;
    }

}
