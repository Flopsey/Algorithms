package search_sort;

public class HeapSort {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        heapSort(array);
        System.out.println(java.util.Arrays.toString(array));  // {27, 34, 39, 48, 70, 86, 87, 91, 95, 100}
    }

    public static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; --i) {
            restoreHeapCondition(a, i, a.length);
        }
        for (int m = a.length - 1; m >= 1; --m) {
            int temp = a[0];
            a[0] = a[m];
            a[m] = temp;
            restoreHeapCondition(a, 0, m - 1);
        }
    }

    private static void restoreHeapCondition(int[] a, int i, int heapSize) {
        while (2 * i <= heapSize) {
            int j = 2 * i;
            if (j + 1 <= heapSize) {
                if (a[j] < a[j + 1]) {
                    ++j;
                }
            }
            if (a[i] >= a[j]) {
                return;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i = j;
        }
    }

}
