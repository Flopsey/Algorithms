package search_sort;

public class HeapSort {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        heapSort(array);
        System.out.println(java.util.Arrays.toString(array));  // {27, 34, 39, 48, 70, 86, 87, 91, 95, 100}
    }

    public static void heapSort(int[] A) {
        for (int i = A.length / 2 - 1; i >= 0; --i) {
            restoreHeapCondition(A, i, A.length);
        }
        for (int m = A.length - 1; m >= 1; --m) {
            int temp = A[0];
            A[0] = A[m];
            A[m] = temp;
            restoreHeapCondition(A, 0, m - 1);
        }
    }

    private static void restoreHeapCondition(int[] A, int i, int m) {
        while (2 * i <= m) {
            int j = 2 * i;
            if (j + 1 <= m) {
                if (A[j] < A[j + 1]) {
                    ++j;
                }
            }
            if (A[i] >= A[j]) {
                return;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i = j;
        }
    }

}
