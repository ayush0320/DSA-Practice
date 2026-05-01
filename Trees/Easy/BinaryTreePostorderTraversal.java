// LC. 145. Binary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // ------------------------

    // Recursive Approach
    // Time Complexity - O(n), n is number of nodes
    // Space Complexity - O(n), worst case for skewed tree
    // O(log n), best case for balanced tree

    public static List<Integer> postorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(postorder(root.left));
        result.addAll(postorder(root.right));
        result.add(root.val);

        return result;
    }

    // ------------------------

    // Iterative Approach
    // Time Complexity - O(n), n is number of nodes
    // Space Complexity - O(n), worst case for skewed tree
    // O(log n), best case for balanced tree

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postorder(root);
        System.out.println(result);
    }
}