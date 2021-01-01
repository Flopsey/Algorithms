package search_sort;

public class SelectionSort {

    public static void main(String[] args) {
        // Example:
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        selectionSort(array);
        System.out.println(java.util.Arrays.toString(array));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
    }

    public static void selectionSort(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            int j = min(A, i);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    private static int min(int[] A, int fromIndex) {
        int j = fromIndex;
        int min = A[j];
        for (int i = j + 1; i < A.length; ++i) {
            if (A[i] < min) {
                min = A[i];
                j = i;
            }
        }
        return j;
    }

}
