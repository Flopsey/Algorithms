package search_sort;

public class BinarySearch {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        System.out.println(binarySearchRecursive(array, 39));  // 2
        System.out.println(binarySearchIterative(array, 39));  // 2
        System.out.println(binarySearchRecursive(array, 40));  // -4 (not found, insertion point: 3)
        System.out.println(binarySearchIterative(array, 40));  // -4 (not found, insertion point: 3)
    }

    public static int binarySearchRecursive(int[] A, int b) {
        return binarySearchRecursive(A, b, 0, A.length);
    }

    private static int binarySearchRecursive(int[] A, int b, int left, int right) {
        int n = right - left;
        if (n == 0) {
            return -right - 1;
        }
        int middle = n / 2 + left;
        if (b == A[middle]) {
            return middle;
        }
        if (b < A[middle]) {
            return binarySearchRecursive(A, b, left, middle);
        } else {
            return binarySearchRecursive(A, b, middle + 1, right);
        }
    }

    public static int binarySearchIterative(int[] A, int b) {
        return binarySearchIterative(A, b, 0, A.length - 1);
    }

    static int binarySearchIterative(int[] A, int b, int left, int right) {
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
        return -left - 1;
    }

}
