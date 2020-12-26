package search_sort;

public class BubbleSort {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        bubbleSort(array);
        System.out.println(java.util.Arrays.toString(array));  // {27, 34, 39, 48, 70, 86, 87, 91, 95, 100}
    }

    public static void bubbleSort(int[] A) {
        for (int j = 0; j < A.length - 1; ++j) {
            for (int i = 0; i < A.length - j - 1; ++i) {
                if (A[i] > A[i + 1]) {
                    int temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                }
            }
        }
    }

}
