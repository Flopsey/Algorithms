package data_structures;

public class BinarySearchTree<E extends Comparable<? super E>> implements Dictionary<E> {

    protected TreeNode<E> root;

    @SuppressWarnings("CastCanBeRemovedNarrowingVariableType")
    public static void main(String[] args) {
        // Example:
        Dictionary<Integer> dict = new BinarySearchTree<>();
        int[] keys1 = {91, 34, 86, 39, 27, 87, 70, 48, 100, 95};
        int[] keys2 = {100, 39, 48, 86, 27, 87, 95, 91, 70, 34};
        for (int key : keys1) {
            dict.insert(key);
        }
        for (int key : keys1) {
            System.out.println(dict.search(key));  // true
        }
        System.out.println(dict.search(101));  // false
        for (int key : keys2) {
            dict.remove(key);
        }
        dict.remove(101);
        System.out.println(((BinarySearchTree<Integer>) dict).root);  // null
    }

    @Override
    public boolean search(E e) {
        return searchNode(e).node != null;
    }

    protected SearchResult<E> searchNode(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> node = root;
        if (node == null) {
            return new SearchResult<>(null, null, 0);
        }
        while (true) {
            int side = e.compareTo(node.value);
            if (side < 0) {
                if (node.left == null) {
                    return new SearchResult<>(null, node, side);
                }
                parent = node;
                node = node.left;
            } else if (side > 0) {
                if (node.right == null) {
                    return new SearchResult<>(null, node, side);
                }
                parent = node;
                node = node.right;
            }
            if (node.value.equals(e)) {
                return new SearchResult<>(node, parent, side);
            }
        }
    }

    @Override
    public void insert(E e) {
        SearchResult<E> searchResult = searchNode(e);
        TreeNode<E> newNode = new TreeNode<>(e);
        if (searchResult.side < 0) {
            searchResult.parent.left = newNode;
        } else if (searchResult.side > 0) {
            searchResult.parent.right = newNode;
        } else {
            if (searchResult.parent == null) {
                root = newNode;
            } else {
                searchResult.parent = newNode;
            }
        }
    }

    @Override
    public void remove(E e) {
        remove(searchNode(e));
    }

    private void remove(SearchResult<E> searchResult) {
        if (searchResult.node == null) {
            return;
        }
        TreeNode<E> newNode;
        if (searchResult.node.left == null && searchResult.node.right == null) {
            newNode = null;
        } else if (searchResult.node.left == null) {
            newNode = searchResult.node.right;
        } else if (searchResult.node.right == null) {
            newNode = searchResult.node.left;
        } else {
            SearchResult<E> symSucc = symmetricalSuccessor(searchResult.node);
            newNode = searchResult.node;
            newNode.value = symSucc.node.value;
            remove(symSucc);
        }
        if (searchResult.side < 0) {
            searchResult.parent.left = newNode;
        } else if (searchResult.side > 0) {
            searchResult.parent.right = newNode;
        } else {
            root = newNode;
        }
    }

    private SearchResult<E> symmetricalSuccessor(TreeNode<E> node) {
        TreeNode<E> parent = node;
        node = node.right;
        int side = 1;
        while (node.left != null) {
            parent = node;
            node = node.left;
            side = -1;
        }
        return new SearchResult<>(node, parent, side);
    }

    protected static class TreeNode<E> {

        protected E value;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }

    }

    protected static class SearchResult<E> {

        protected final TreeNode<E> node;
        protected TreeNode<E> parent;
        protected final int side;

        public SearchResult(TreeNode<E> node, TreeNode<E> parent, int side) {
            this.node = node;
            this.parent = parent;
            this.side = side;
        }

    }

}
