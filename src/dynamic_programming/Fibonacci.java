package dynamic_programming;

public class Fibonacci {

    public static void main(String[] args) {
        // Example:
        printTiming("Top-down", Fibonacci::fibonacciRecursive, 42);  // 267914296
        printTiming("Top-down DP", Fibonacci::fibonacciRecursiveMemoization, 42);  // 267914296
        printTiming("Bottom-up DP", Fibonacci::fibonacciIterative, 42);  // 267914296
    }

    private static void printTiming(String funcName, java.util.function.Function<Integer, Integer> func, int n) {
        System.out.println(funcName + ":");
        long t1;
        long t2;
        int result;
        t1 = System.nanoTime();
        result = func.apply(n);
        t2 = System.nanoTime();
        System.out.println(result);
        System.out.println("Took " + ((double) (t2 - t1) / 1_000_000) + " ms");
        System.out.println();
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciRecursiveMemoization(int n) {
        return fibonacciRecursiveMemoization(n, new int[n]);
    }

    private static int fibonacciRecursiveMemoization(int n, int[] memo) {
        if (n <= 2) {
            return 1;
        }
        int next = memo[n - 1];
        if (next == 0) {
            next = fibonacciRecursiveMemoization(n - 1, memo) + fibonacciRecursiveMemoization(n - 2, memo);
            memo[n - 1] = next;
        }
        return next;
    }

    public static int fibonacciIterative(int n) {
        int[] table = new int[2];
        table[0] = 1;
        table[1] = 1;
        for (int i = 2; i < n; ++i) {
            int next = table[0] + table[1];
            table[0] = table[1];
            table[1] = next;
        }
        return table[1];
    }

}
