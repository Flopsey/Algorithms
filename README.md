# Algorithms and data structures
Collection of various algorithms and data structures implemented in Java. The content of this is based on the course
["Algorithms and Data Structures" at ETH Zürich](http://www.vorlesungsverzeichnis.ethz.ch/Vorlesungsverzeichnis/lerneinheit.view?lerneinheitId=139780&semkez=2020W&ansicht=KATALOGDATEN&lang=en)
and [this script](https://www.cadmo.ethz.ch/education/lectures/HS16/DA/skript/skript.pdf) [access restricted].

## To-do list [63% complete]
* [x] [Karatsuba](src/Karatsuba.java)
* [ ] Pasture break
* [ ] Find the star
* [x] [Maximum subarray sum](src/MaximumSubarraySum.java)
* Sorting and search algorithms
    * Search
        * [x] [Binary search](src/search_sort/BinarySearch.java)
            * Variant: Recursive
            * Variant: Iterative
        * [x] [Interpolation search](src/search_sort/InterpolationSearch.java)
        * [x] [Linear search](src/search_sort/LinearSearch.java)
    * Sorting
        * [x] ([Sortedness](src/search_sort/Sortedness.java))
        * [x] [Bubble sort](src/search_sort/BubbleSort.java)
        * [x] [Selection sort](src/search_sort/SelectionSort.java)
        * [x] [Insertion sort](src/search_sort/InsertionSort.java)
        * [x] [Heap sort](src/search_sort/HeapSort.java)
        * [x] [Merge sort](src/search_sort/MergeSort.java)
            * Variant: Recursive
            * Variant: Straight merge sort (iterative)
            * Variant: Natural merge sort
        * [x] [Quicksort](src/search_sort/QuickSort.java)
* Dynamic Programming
    * [x] [Fibonacci sequence](src/dynamic_programming/Fibonacci.java)
        * Variant: Recursive / top-down naive
        * Variant: Recursive / top-down DP (Memoization)
        * Variant: Iterative / bottom-up DP
    * [x] [Longest increasing subsequence](src/dynamic_programming/LongestIncreasingSubsequence.java)
    * [x] [Longest common subsequence](src/dynamic_programming/LongestCommonSubsequence.java)
    * [x] [Edit distance](src/dynamic_programming/EditDistance.java)
    * [ ] Matrix chain multiplication
    * [x] [Subset sum problem](src/dynamic_programming/SubsetSum.java)
    * [x] [Knapsack problem](src/dynamic_programming/Knapsack.java)
        * Variant: Max value
        * Variant: Min weight
        * Variant: Min weight with approximated values
* Datastructures for dictionaries
    * [x] [Linked List](src/datastructures_for_dictionaries/LinkedList.java)
    * Abstract data types
        * [x] [Stack](src/datastructures_for_dictionaries/Stack.java) with its [implementation using a linked list](src/datastructures_for_dictionaries/LinkedListStack.java)
        * [x] [Queue](src/datastructures_for_dictionaries/Queue.java) with its [implementation unsing a linked list](src/datastructures_for_dictionaries/LinkedListQueue.java)
        * [x] [Priority Queue](src/datastructures_for_dictionaries/PriorityQueue.java) with its [implementation using a min-heap](src/datastructures_for_dictionaries/HeapPriorityQueue.java)
        * [x] [Dictionary](src/datastructures_for_dictionaries/Dictionary.java) — implemented by:
            * [x] [Binary search tree](src/datastructures_for_dictionaries/BinarySearchTree.java)
                * [ ] AVL tree
* Graph algorithms
    * [x] [Graph](src/graph_algorithms/Graph.java) ([weighted](src/graph_algorithms/GraphWeighted.java)/[unweighted](src/graph_algorithms/GraphUnweighted.java))
        * [x] Adjacency matrix ([weighted](src/graph_algorithms/AdjacencyMatrixWeighted.java)/[unweighted](src/graph_algorithms/AdjacencyMatrixUnweighted.java))
        * [x] Adjacency list ([weighted](src/graph_algorithms/AdjacencyListWeighted.java)/[unweighted](src/graph_algorithms/AdjacencyListUnweighted.java))
    * [x] [Depth-first search](src/graph_algorithms/DepthFirstSearch.java)
    * [x] [Breadth-first search](src/graph_algorithms/BreadthFirstSearch.java)
    * [ ] Topological sort
    * Shortest Paths
        * [ ] BFS shortest path
        * [ ] Dijkstra
        * [ ] Bellman-Ford
        * [ ] Floyd-Warshall
        * [ ] Johnson
        * [ ] Strassen
    * Minimum spanning trees
        * [ ] Boruvka
        * [ ] Prim
        * [ ] Kruskal
        * [ ] Union-Find
    * Selection
        * [ ] Quickselect
