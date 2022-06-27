package sorting_searching;

import java.util.Comparator;

public class Sortedness {

    public static void main(String[] args) {
        // Example:
        int[] sorted = {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        int[] unsorted = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        System.out.println(isSorted(sorted));  // true
        System.out.println(isSorted(unsorted));  // false
    }

    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] a) {
        return isSorted(a, Comparator.naturalOrder());
    }

    public static <T> boolean isSorted(T[] a, Comparator<T> comp) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (comp.compare(a[i], a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}
