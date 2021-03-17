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

    public static void mergeSort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    private static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }

    public static void straightMergeSort(int[] A) {
        for (int length = 1; length < A.length; length *= 2) {
            int right = -1;
            while (right + length < A.length) {
                int left = right + 1;
                int middle = left + length - 1;
                right = Math.min(middle + length, A.length - 1);
                merge(A, left, middle, right);
            }
        }
    }

    public static void naturalMergeSort(int[] A) {
        int left;
        do {
            int right = -1;
            left = right + 1;
            while (right < A.length - 1) {
                left = right + 1;
                int middle = left;
                while (middle < A.length - 1 && A[middle + 1] >= A[middle]) {
                    ++middle;
                }
                if (middle < A.length - 1) {
                    right = middle + 1;
                    while (right < A.length - 1 && A[right + 1] >= A[right]) {
                        ++right;
                    }
                    merge(A, left, middle, right);
                } else {
                    right = A.length - 1;
                }
            }
        } while (left > 0);
    }

    private static void merge(int[] A, int left, int middle, int right) {
        int[] B = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (A[i] <= A[j]) {
                B[k] = A[i];
                ++i;
            } else {
                B[k] = A[j];
                ++j;
            }
            ++k;
        }
        while (i <= middle) {
            B[k] = A[i];
            ++i;
            ++k;
        }
        while (j <= right) {
            B[k] = A[j];
            ++j;
            ++k;
        }
        for (k = left; k <= right; ++k) {
            A[k] = B[k - left];
        }

    }

}
