package sorting_searching;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};

        // Example:

        int[] array1 = array.clone();
        mergeSort(array1);
        System.out.println(java.util.Arrays.toString(array1));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]

        int[] array2 = array.clone();
        straightMergeSort(array2);
        System.out.println(java.util.Arrays.toString(array2));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]

        int[] array3 = array.clone();
        naturalMergeSort(array3);
        System.out.println(java.util.Arrays.toString(array3));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
    }

    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(a, left, middle);
            mergeSort(a, middle + 1, right);
            merge(a, left, middle, right);
        }
    }

    public static void straightMergeSort(int[] a) {
        for (int length = 1; length < a.length; length *= 2) {
            int right = -1;
            while (right + length < a.length) {
                int left = right + 1;
                int middle = left + length - 1;
                right = Math.min(middle + length, a.length - 1);
                merge(a, left, middle, right);
            }
        }
    }

    public static void naturalMergeSort(int[] a) {
        int left;
        do {
            int right = -1;
            left = right + 1;
            while (right < a.length - 1) {
                left = right + 1;
                int middle = left;
                while (middle < a.length - 1 && a[middle + 1] >= a[middle]) {
                    ++middle;
                }
                if (middle < a.length - 1) {
                    right = middle + 1;
                    while (right < a.length - 1 && a[right + 1] >= a[right]) {
                        ++right;
                    }
                    merge(a, left, middle, right);
                } else {
                    right = a.length - 1;
                }
            }
        } while (left > 0);
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] B = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (a[i] <= a[j]) {
                B[k] = a[i];
                ++i;
            } else {
                B[k] = a[j];
                ++j;
            }
            ++k;
        }
        while (i <= middle) {
            B[k] = a[i];
            ++i;
            ++k;
        }
        while (j <= right) {
            B[k] = a[j];
            ++j;
            ++k;
        }
        for (k = left; k <= right; ++k) {
            a[k] = B[k - left];
        }

    }

}
