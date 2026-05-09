// LC 700. Search In Binary Search Tree

package bst.easy;

public class SearchInBST {

    // Class to define a single node of a tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    public static TreeNode searchBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return root;
        }

        else if (key < root.val) {
            return searchBST(root.left, key);
        }

        return searchBST(root.right, key);
    }

    // ----------------------------------------------

    public static void main(String[] args) {
        int values[] = { 4, 2, 7, 1, 3 };
        TreeNode root = null;

        // Insert nodes
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        int key = 7;

        TreeNode result = searchBST(root, key);
        System.out.println(result.val);

    }
}
