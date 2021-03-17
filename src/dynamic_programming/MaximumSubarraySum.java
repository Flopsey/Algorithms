package dynamic_programming;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        // Example:
        double[] array = {7, -11, 18, 10, -23, -3, 27, -1};
        System.out.println(maximumSubarraySum(array));  // 18 + 10 + -23 + -3 + 27 = 29
    }

    public static double maximumSubarraySum(double[] a) {
        double edgemax = 0;
        double maxS = 0;
        for (double v : a) {
            edgemax += v;
            maxS = Math.max(maxS, edgemax);
            edgemax = Math.max(0, edgemax);
        }
        return maxS;
    }

}
