// LC. 572 Subtree of Another Tree

package trees.easy;

public class SubTreeOfAnotherTree {

    // Definition for a binarytree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for an empty node
        TreeNode() {
        }

        // Constructor for a node with a value
        TreeNode(int val) {
            this.val = val;
        }

        // Constructor for a node with a value and left and right children
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // --------------------

    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        if (root.val != subRoot.val)
            return false;

        return isIdentical(root.left, subRoot.left)
                && isIdentical(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSubtree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // ====================

    public static void main(String[] args) {

    }
}
