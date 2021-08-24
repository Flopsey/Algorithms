// Based on Parallel Programming PVW Script
// https://cdn.vis.ethz.ch/luk/pvw_paralleleprogrammierung.pdf

package parallel_programming;

import mpi.MPI;

abstract public class MPIExample {

    public static void computePrimeFactors(int[] arr) {
        // We assume MPI.Init() has already been called
        int size = MPI.COMM_WORLD.Size();
        int rank = MPI.COMM_WORLD.Rank();
        int partSize = arr.length / size;
        int[] res = new int[partSize];
        for (int i = rank * partSize, j = 0; i < arr.length; ++i, ++j) {
            if (rank == 0) {
                arr[i] = primeFactors(arr[i]);
            } else {
                res[j] = primeFactors(arr[i]);
            }
        }
        if (rank != 0) {
            MPI.COMM_WORLD.Send(res, 0, partSize, MPI.INT, 0, 42);
        } else {
            for (int i = 1; i < size; ++i) {
                MPI.COMM_WORLD.Recv(arr, i * partSize, partSize, MPI.INT, i, 42);
            }
        }
        // We assume MPI.Finalize() will be called
    }

    private static int primeFactors(int n) {
        // TODO: Actual implementation
        return -1;
    }

}
