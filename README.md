# Algorithms and data structures
Collection of various algorithms and data structures implemented in Java. The content of this is based on the courses
[Algorithms and Data Structures](http://u.ethz.ch/WhFBD) and [Algorithms and Probability](http://u.ethz.ch/KPvXW) at ETH
Zürich.

## Contents
### Sorting, Searching
* Sorting
    * [Sortedness](src/sorting_searching/Sortedness.java)
    * [Bubble sort](src/sorting_searching/BubbleSort.java)
    * [Selection sort](src/sorting_searching/SelectionSort.java)
    * [Insertion sort](src/sorting_searching/InsertionSort.java)
    * [Heap sort](src/sorting_searching/HeapSort.java)
    * [Merge sort](src/sorting_searching/MergeSort.java)
    * [Quicksort](src/sorting_searching/QuickSort.java)
* Searching
    * [Binary search](src/sorting_searching/BinarySearch.java)
    * [Interpolation search](src/sorting_searching/InterpolationSearch.java)
    * [Linear search](src/sorting_searching/LinearSearch.java)

### Dynamic Programming
* [Maximum subarray sum](src/dynamic_programming/MaximumSubarraySum.java)
* [Fibonacci sequence](src/dynamic_programming/Fibonacci.java)
* [Longest increasing subsequence](src/dynamic_programming/LongestIncreasingSubsequence.java)
* [Longest common subsequence](src/dynamic_programming/LongestCommonSubsequence.java)
* [Edit distance](src/dynamic_programming/EditDistance.java)
* [Subset sum problem](src/dynamic_programming/SubsetSum.java)
* [Knapsack problem](src/dynamic_programming/Knapsack.java)

### Data Structures
* [Linked List](src/data_structures/LinkedList.java)
* Abstract data types
    * [Stack](src/data_structures/Stack.java) with its
      [implementation using a linked list](src/data_structures/LinkedListStack.java)
    * [Queue](src/data_structures/Queue.java) with its
      [implementation using a linked list](src/data_structures/LinkedListQueue.java)
    * [Priority Queue](src/data_structures/PriorityQueue.java) with its
      [implementation using a min-heap](src/data_structures/Heap.java)
    * [Dictionary](src/data_structures/Dictionary.java) — implemented by:
        * [Binary search tree](src/data_structures/BinarySearchTree.java)

### Graphs
* [Graph](src/graphs/Graph.java)
  ([weighted](src/graphs/GraphWeighted.java)/[unweighted](src/graphs/GraphUnweighted.java))
    * Adjacency matrix
      ([weighted](src/graphs/AdjacencyMatrixWeighted.java)/[unweighted](src/graphs/AdjacencyMatrixUnweighted.java))
    * Adjacency list
      ([weighted](src/graphs/AdjacencyListWeighted.java)/[unweighted](src/graphs/AdjacencyListUnweighted.java))
* [Depth-first search](src/graphs/DepthFirstSearch.java)
* [Breadth-first search](src/graphs/BreadthFirstSearch.java)
* [Topological sort](src/graphs/TopologicalSort.java)
* Shortest Paths
    * [BFS shortest path](src/graphs/BreadthFirstSearchShortestPath.java)
    * [Dijkstra](src/graphs/Dijkstra.java)
    * [Bellman-Ford](src/graphs/BellmanFord.java)
    * [Floyd-Warshall](src/graphs/FloydWarshall.java)

### Parallel Programming
* [Thread spawning](src/parallel_programming/ThreadSpawnExample.java)
* [Thread spawning and joining](src/parallel_programming/ThreadSpawnJoinExample.java)
* [Executor service](src/parallel_programming/ExecutorServiceExample.java)
* [Fork/Join](src/parallel_programming/ForkJoinExample.java)
* [Peterson lock](src/parallel_programming/PetersonLock.java)
* [Filter lock](src/parallel_programming/FilterLock.java)
* [Bakery lock](src/parallel_programming/BakeryLock.java)

### Miscellaneous
* [Karatsuba](src/miscellaneous/Karatsuba.java)
