// LC 94. Binary Tree Inorder Traversal

// DFS Traversal 
// Preorder:  Root  -> Left  -> Right
// Inorder:   Left  -> Root  -> Right
// Postorder: Left  -> Right -> Root

//--------------------------------------------------------------
package trees.easy;

import java.util.*;

public class BinaryTreeInorderTraversal {

    // Definition for a binary tree node.
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
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) in the worst case (skewed tree),
    // O(log n) in the best case (balanced tree)

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result; // Return an empty list if the tree is empty
        }

        // Traverse the left subtree
        result.addAll(inorder(root.left));
        // Visit the root node
        result.add(root.val);
        // Traverse the right subtree
        result.addAll(inorder(root.right));
        return result;
    }

    // ------------------------

    // Iterative Approach using Stack
    // Time Complexity: O(n) where n is the number of nodes in the tree
    // Space Complexity: O(n) in the worst case (skewed tree),
    // O(log n) in the best case (balanced tree)

    public static List<Integer> inorderTraveral(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go to leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);

            curr = curr.right;
        }

        return result;
    }

    // ========================

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorder(root);
        System.out.println(result); // Output: [1, 3, 2]
    }
}
