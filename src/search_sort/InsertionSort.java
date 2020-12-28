package search_sort;

public class InsertionSort {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        insertionSort(array);
        System.out.println(java.util.Arrays.toString(array));  // {27, 34, 39, 48, 70, 86, 87, 91, 95, 100}
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; ++i) {
            int k = -(BinarySearch.binarySearchIterative(a, a[i], 0, i - 1) + 1);
            int temp = a[i];
            System.arraycopy(a, k, a, k + 1, i - k);
            a[k] = temp;
        }
    }

}
