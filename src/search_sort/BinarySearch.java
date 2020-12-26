package search_sort;

public class BinarySearch {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        System.out.println(binarySearchRecursive(array, 39));  // 2
        System.out.println(binarySearchIterative(array, 39));  // 2
        System.out.println(binarySearchRecursive(array, 40));  // -1 (not found)
        System.out.println(binarySearchIterative(array, 40));  // -1 (not found)
    }

    public static int binarySearchRecursive(int[] A, int b) {
        return binarySearchRecursive(A, b, 0, A.length);
    }

    private static int binarySearchRecursive(int[] A, int b, int left, int right) {
        int n = right - left;
        if (n <= 1) {
            return -1;
        }
        int middle = n / 2 + left;
        if (b == A[middle]) {
            return middle;
        }
        if (b < A[middle]) {
            return binarySearchRecursive(A, b, left, middle);
        } else {
            return binarySearchRecursive(A, b, middle, right);
        }
    }

    public static int binarySearchIterative(int[] A, int b) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (A[middle] == b) {
                return middle;
            }
            if (b < A[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
