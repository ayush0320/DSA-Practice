// LC. 110 Balanced Binary Tree
// -> Balanced Tree - a binary tree in which the difference 
// between the heights of the left and right subtrees is 
// no more than one for every node in the tree.
// -> The height of the tree is logarithmic O(log n) 
// with respect to the number of nodes (n).
// -> For every nodes:
// |height(left subtree) - height(right subtree)| ≤ 1

//--------------------------------------------------------------

package trees.easy;

import trees.model.TreeNode;

public class BalancedBinaryTree {

    // Recursive Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(h) - where h is the height of the tree, which is the
    // maximum depth of the tree.
    // In the worst case (when the tree is completely unbalanced), the space
    // complexity can be O(n).
    // Math.abs() - returns the absolute value of a number,
    // which is the non-negative value of that number without regard to its sign.

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));

    }

    // ------------------------

    // Optimized Recursive Approach

    public static boolean isBalancedII(TreeNode root) {
        return check(root) != -1;
    }

    // Time Complexity: O(n) - we visit each node once
    // Space Complexity: O(h) - where h is the height of the tree, which
    private static int check(TreeNode root) {
        if (root == null)
            return 0;

        // Check the height of the left subtree and return -1 if it is not balanced.
        int left = check(root.left);
        if (left == -1)
            return -1;

        // Check the height of the right subtree and return -1 if it is not balanced.
        int right = check(root.right);
        if (right == -1)
            return -1;

        // If the difference in height is greater than 1, return -1 to indicate that the
        // tree is not balanced.
        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
        ;
    }
}
