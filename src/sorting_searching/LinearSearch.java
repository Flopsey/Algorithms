package sorting_searching;

import java.util.Comparator;

public class LinearSearch {

    public static void main(String[] args) {
        // Example:
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        System.out.println(linearSearch(array, 39));  // 3
        System.out.println(linearSearch(array, 40));  // -1 (not found)
    }

    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<? super T>> int linearSearch(T[] a, T key) {
        return linearSearch(a, key, Comparator.naturalOrder());
    }

    public static <T> int linearSearch(T[] a, T key, Comparator<T> comp) {
        for (int i = 0; i < a.length; ++i) {
            if (comp.compare(a[i], key) == 0) {
                return i;
            }
        }
        return -1;
    }

}
