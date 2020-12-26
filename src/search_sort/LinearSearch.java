package search_sort;

public class LinearSearch {

    public static void main(String[] args) {
        // Example:
        int[] array = new int[] {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        System.out.println(linearSearch(array, 39));  // 3
        System.out.println(linearSearch(array, 40));  // -1 (not found)
    }

    public static int linearSearch(int[] A, int b) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == b) {
                return i;
            }
        }
        return -1;
    }

}
