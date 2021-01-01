package search_sort;

public class QuickSort {

    public static void main(String[] args) {
        // Example:
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        quickSort(array);
        System.out.println(java.util.Arrays.toString(array));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
    }

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = partition(a, left, right);
        quickSort(a, left, k - 1);
        quickSort(a, k + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int i = left;
        int j = right - 1;
        int pivot = a[right];
        do {
            while (i < right && a[i] < pivot) {
                ++i;
            }
            while (j > left && a[j] > pivot) {
                --j;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);
        int temp = a[i];
        a[i] = a[right];
        a[right] = temp;
        return i;
    }

}
