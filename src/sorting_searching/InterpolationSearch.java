package sorting_searching;

public class InterpolationSearch {

    public static void main(String[] args) {
        // Example:
        int[] array = {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        System.out.println(interpolationSearch(array, 39));  // 2
        System.out.println(interpolationSearch(array, 40));  // -1 (not found)
    }

    public static int interpolationSearch(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int middle = left + ((key - a[left]) / (a[right] - a[left])) * (right - left);
            if (a[middle] == key) {
                return middle;
            }
            if (key < a[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
