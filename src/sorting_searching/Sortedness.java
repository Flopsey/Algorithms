package sorting_searching;

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

}
