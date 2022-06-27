package sorting_searching;

import java.util.Comparator;

public class BubbleSort {

    public static void main(String[] args) {
        // Example:
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        bubbleSort(array);
        System.out.println(java.util.Arrays.toString(array));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
    }

    public static void bubbleSort(int[] a) {
        for (int j = 0; j < a.length - 1; ++j) {
            for (int i = 0; i < a.length - j - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
        bubbleSort(a, Comparator.naturalOrder());
    }

    public static <T> void bubbleSort(T[] a, Comparator<T> comp) {
        for (int j = 0; j < a.length - 1; ++j) {
            for (int i = 0; i < a.length - j - 1; ++i) {
                if (comp.compare(a[i], a[i + 1]) > 0) {
                    T temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

}
