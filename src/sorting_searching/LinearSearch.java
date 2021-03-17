package sorting_searching;

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

}
