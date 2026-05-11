// LC 98. Validate Binary Search Tree
// https://youtu.be/f-sj7I5oXEI

package bst.medium;

import bst.BinarySearchTree;
import bst.BinarySearchTree.TreeNode;

public class ValidateBinarySearchTree {

    // Validate range
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val) &&
                validate(root.right, root.val, max);
    }

    // ----------------------------------------------
    public static void main(String[] args) {
        int[] values = { 2147483647 };
        TreeNode root = null;

        for (int i = 0; i < values.length; i++) {
            root = BinarySearchTree.insert(root, values[i]);
        }

        System.err.println(isValidBST(root));
    }
}
