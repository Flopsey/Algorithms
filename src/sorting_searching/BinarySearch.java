package sorting_searching;

import java.util.Comparator;

public class BinarySearch {

    public static void main(String[] args) {
        // Example:
        int[] array = {27, 34, 39, 48, 70, 86, 87, 91, 95, 100};
        System.out.println(binarySearchRecursive(array, 39));  // 2
        System.out.println(binarySearchIterative(array, 39));  // 2
        System.out.println(binarySearchRecursive(array, 40));  // -4 (not found, insertion point: 3)
        System.out.println(binarySearchIterative(array, 40));  // -4 (not found, insertion point: 3)
    }

    public static int binarySearchRecursive(int[] a, int key) {
        return binarySearchRecursive(a, key, 0, a.length);
    }

    private static int binarySearchRecursive(int[] a, int key, int left, int right) {
        int n = right - left;
        if (n == 0) {
            return -right - 1;
        }
        int middle = n / 2 + left;
        if (key == a[middle]) {
            return middle;
        }
        if (key < a[middle]) {
            return binarySearchRecursive(a, key, left, middle);
        } else {
            return binarySearchRecursive(a, key, middle + 1, right);
        }
    }

    public static <T extends Comparable<? super T>> int binarySearchRecursive(T[] a, T key) {
        return binarySearchRecursive(a, key, Comparator.naturalOrder());
    }

    public static <T> int binarySearchRecursive(T[] a, T key, Comparator<T> comp) {
        return binarySearchRecursive(a, key, comp, 0, a.length);
    }

    private static <T> int binarySearchRecursive(T[] a, T key, Comparator<T> comp, int left, int right) {
        int n = right - left;
        if (n == 0) {
            return -right - 1;
        }
        int middle = n / 2 + left;
        if (key == a[middle]) {
            return middle;
        }
        if (comp.compare(key, a[middle]) < 0) {
            return binarySearchRecursive(a, key, comp, left, middle);
        } else {
            return binarySearchRecursive(a, key, comp, middle + 1, right);
        }
    }

    public static int binarySearchIterative(int[] a, int key) {
        return binarySearchIterative(a, key, 0, a.length - 1);
    }

    static int binarySearchIterative(int[] a, int key, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] == key) {
                return middle;
            }
            if (key < a[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -left - 1;
    }

    public static <T extends Comparable<? super T>> int binarySearchIterative(T[] a, T key) {
        return binarySearchIterative(a, key, Comparator.naturalOrder());
    }

    public static <T> int binarySearchIterative(T[] a, T key, Comparator<T> comp) {
        return binarySearchIterative(a, key, comp, 0, a.length - 1);
    }

    static <T> int binarySearchIterative(T[] a, T key, Comparator<T> comp, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] == key) {
                return middle;
            }
            if (comp.compare(key, a[middle]) < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -left - 1;
    }

}
