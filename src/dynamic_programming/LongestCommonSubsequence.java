package dynamic_programming;

import data_structures.LinkedList;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // Example:
        System.out.println(longestCommonSubsequence("ZIEGE".toCharArray(), "TIGER".toCharArray()));  // ['I', 'G', 'E']
        System.out.println(longestCommonSubsequence("COVID".toCharArray(), "PARTY".toCharArray()));  // []
    }

    public static LinkedList<Character> longestCommonSubsequence(char[] a, char[] b) {
        int[][] table = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; ++i) {
            table[i][0] = 0;
        }
        for (int j = 0; j < b.length + 1; ++j) {
            table[0][j] = 0;
        }

        for (int i = 1; i < table.length; ++i) {
            for (int j = 1; j < table[i].length; ++j) {
                table[i][j] = max(
                        table[i - 1][j],
                        table[i][j - 1],
                        table[i - 1][j - 1] + (a[i - 1] == b[j - 1] ? 1 : 0)
                );
            }
        }

        LinkedList<Character> solution = new LinkedList<>();
        int i = a.length;
        int j = b.length;
        while (!(i == 0 || j == 0)) {
            char charA = a[i - 1];
            char charB = b[j - 1];
            if (charA == charB) {
                solution.addFirst(charA);
                i -= 1;
                j -= 1;
            } else if (table[i][j] == table[i][j - 1]) {
                j -= 1;
            } else {
                i -= 1;
            }
        }
        return solution;
    }

    private static int max(int... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException();
        }
        int max = values[0];
        for (int i = 1; i < values.length; ++i) {
            max = Math.max(max, values[i]);
        }
        return max;
    }

}
