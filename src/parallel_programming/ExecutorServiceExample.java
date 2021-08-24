// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    // Will run forever because thread pool size is limited but we need more threads => block
    public static void main(String[] args) {
        int[] arr = new int[]{15, 7, 9, 8, 4, 22, 42, 13};
        ExecutorService ex = Executors.newFixedThreadPool(4);
        MaxTask top = new MaxTask(ex, 0, arr.length, arr);
        Future<Integer> max = ex.submit(top);
        try {
            System.out.println(max.get());
        } catch (Exception ignored) { }
        ex.shutdown();
    }

}

class MaxTask implements Callable<Integer> {

    int l, h;
    int[] arr;
    ExecutorService ex;

    MaxTask(ExecutorService ex, int lo, int hi, int[] arr) {
        this.l = lo;
        this.h = hi;
        this.arr = arr;
        this.ex = ex;
    }

    public Integer call() {
        // Check base case
        int size = h - l;
        if (size == 1) {
            return arr[l];
        }

        // Split work
        int mid = size / 2;
        MaxTask m1 = new MaxTask(ex, l, l + mid, arr);
        MaxTask m2 = new MaxTask(ex, l + mid, h, arr);

        // Start subtasks
        Future<Integer> f1 = ex.submit(m1);
        Future<Integer> f2 = ex.submit(m2);

        // Combine Results
        try {
            return Math.max(f1.get(), f2.get());
        } catch (Exception e) {
            return 0;
        }
    }

}
