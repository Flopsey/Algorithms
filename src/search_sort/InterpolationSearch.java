package search_sort;

public class InterpolationSearch {

    public static void main(String[] args) {
        // Example:
        int[] array = {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        System.out.println(interpolationSearch(array, 39));  // 2
        System.out.println(interpolationSearch(array, 40));  // -1 (not found)
    }

    public static int interpolationSearch(int[] A, int b) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int middle = left + ((b - A[left]) / (A[right] - A[left])) * (right - left);
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
