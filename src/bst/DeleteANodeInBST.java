//https://youtu.be/qAeitQWjNNg?t=2061

package bst;

public class DeleteANodeInBST {

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

    // Delete a node
    public static TreeNode delete(TreeNode root, int n) {

        // Find the node
        if (n < root.val) {
            root.left = delete(root.left, n);
        }

        else if (n > root.val) {
            root.right = delete(root.right, n);
        }

        // Delete
        else {

            // case 1 - leaf node
            // root.val == n
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 - one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 - two children
            TreeNode is = inorderSuccessor(root.right);
            root.val = is.val;
            root.right = delete(root.right, is.val);
        }

        return root;
    }

    // Inorder successor - Smallest value in RIGHT subtree.
    public static TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        delete(root, 4);
        inorder(root);
    }
}
