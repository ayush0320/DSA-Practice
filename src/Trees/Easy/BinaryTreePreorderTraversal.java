package trees.easy;

// LC. 144. Binary Tree Preorder Traversal
import java.util.*;

public class BinaryTreePreorderTraversal {
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

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(preorder(root.left));
        result.addAll(preorder(root.right));

        return result;
    }

    // ------------------------

    // Iterative Approach
    // Time Complexity - O(n), n is number of nodes
    // Space Complexity - O(n), worst case for skewed tree
    // O(log n), best case for balanced tree

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Iterate the leftmost tree
            while (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }

        return result;
    }

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = preorder(root);
        System.out.println(result);
    }
}
