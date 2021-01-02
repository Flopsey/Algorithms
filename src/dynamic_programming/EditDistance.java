package dynamic_programming;

public class EditDistance {

    public static void main(String[] args) {
        // Example:
        System.out.println(editingDistance("ZIEGE", "TIGER"));  // 3
    }

    public static int editingDistance(String a, String b) {
        int[][] table = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; ++i) {
            table[i][0] = i;
        }
        for (int j = 0; j < b.length() + 1; ++j) {
            table[0][j] = j;
        }

        for (int i = 1; i < table.length; ++i) {
            for (int j = 1; j < table[i].length; ++j) {
                table[i][j] = min(
                        table[i - 1][j] + 1,
                        table[i][j - 1] + 1,
                        table[i - 1][j - 1] + (a.charAt(i - 1) != b.charAt(j - 1) ? 1 : 0)
                );
            }
        }

        return table[table.length - 1][table[table.length - 1].length - 1];
    }

    private static int min(int... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException();
        }
        int min = values[0];
        for (int i = 1; i < values.length; ++i) {
            min = Math.min(min, values[i]);
        }
        return min;
    }

}
