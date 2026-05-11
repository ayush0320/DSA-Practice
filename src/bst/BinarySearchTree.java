// https://youtu.be/qAeitQWjNNg
// 1. Left subtree nodes < root
// 2. Right subtree nodes > root
// 3. Left & Right subtrees are also BST with no duplicates

// -> Inorder traversal gives sorted sequence

//--------------------------------------------------------------------

package bst;

public class BinarySearchTree {

    // Class to define a single node of a tree
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // ----------------------------------------------

    // Insert values in BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // ----------------------------------------------

    // Printing BST
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // ----------------------------------------------

    // Searching in BST
    // Worst time complexity: O(h) - h is the height of the tree
    public static boolean search(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.val == key) {
            return true;
        }

        else if (root.val > key) { // left subtree
            return search(root.left, key);
        }

        else if (root.val < key) { // right subtree
            return search(root.right, key);
        }

        return false;
    }

    // ----------------------------------------------

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        // Insert nodes
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 90)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }

}
