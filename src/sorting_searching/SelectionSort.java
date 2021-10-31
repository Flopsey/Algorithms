package sorting_searching;

public class SelectionSort {

    public static void main(String[] args) {
        // Example:
        int[] array = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        selectionSort(array);
        System.out.println(java.util.Arrays.toString(array));  // [27, 34, 39, 48, 70, 86, 87, 91, 95, 100]
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int j = min(a, i);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    private static int min(int[] a, int fromIndex) {
        int j = fromIndex;
        int min = a[j];
        for (int i = j + 1; i < a.length; ++i) {
            if (a[i] < min) {
                min = a[i];
                j = i;
            }
        }
        return j;
    }

}
