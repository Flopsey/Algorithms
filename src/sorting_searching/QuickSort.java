package sorting_searching;

import java.util.Comparator;

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

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, Comparator.naturalOrder(), 0, a.length - 1);
    }

    public static <T> void quickSort(T[] a, Comparator<T> comp) {
        quickSort(a, comp, 0, a.length - 1);
    }

    private static <T> void quickSort(T[] a, Comparator<T> comp, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = partition(a, comp, left, right);
        quickSort(a, comp, left, k - 1);
        quickSort(a, comp, k + 1, right);
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

    private static <T> int partition(T[] a, Comparator<T> comp, int left, int right) {
        int i = left;
        int j = right - 1;
        T pivot = a[right];
        do {
            while (i < right && comp.compare(a[i], pivot) < 0) {
                ++i;
            }
            while (j > left && comp.compare(a[j], pivot) > 0) {
                --j;
            }
            if (i < j) {
                T temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        } while (i < j);
        T temp = a[i];
        a[i] = a[right];
        a[right] = temp;
        return i;
    }

}
