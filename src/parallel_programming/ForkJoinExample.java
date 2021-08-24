// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    public static void main(String[] args) {
        int[] arr = new int[]{15, 7, 9, 8, 4, 22, 42, 13};
        MaxForkJoin tp = new MaxForkJoin(0, arr.length, arr);
        ForkJoinPool fjp = new ForkJoinPool();
        int res = fjp.invoke(tp);
        System.out.println(res);
    }

}

class MaxForkJoin extends RecursiveTask<Integer> {

    int l, h;
    int[] arr;

    MaxForkJoin(int lo, int hi, int[] arr) {
        this.l = lo;
        this.h = hi;
        this.arr = arr;
    }

    protected Integer compute() {
        // Check base case
        int size = h - l;
        if (size == 1) {
            return arr[l];
        }

        // Split work
        int mid = size / 2;
        MaxForkJoin m1 = new MaxForkJoin(l, l + mid, arr);
        MaxForkJoin m2 = new MaxForkJoin(l + mid, h, arr);

        // Run subtasks
        m1.fork();
        int max2 = m2.compute();
        int max1 = m1.join();

        // Combine results
        return Math.max(max1, max2);
    }

}
