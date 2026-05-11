// LC 230. Kth Smallest Element in a BST

package bst.medium;

import java.util.Stack;
import bst.BinarySearchTree;
import bst.BinarySearchTree.TreeNode;

public class KthSmallestElementInBST {

    // ---------------------- RECURSIVE APPROACH ----------------------
    // Inorder traversal always produce sorted output
    // 1. goes left deeply
    // 2. backtracks
    // 3. processes current node
    // 4. moves right
    // Time Complexity : O(n) - number of nodes
    // Space Complexity : O(n) - worst case - skewed tree

    int count = 0; // visited nodes
    int ans = 0;

    public int kth(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        inorder(root.left, k);

        count++;

        if (count == k) {
            ans = root.val;
            return;
        }

        inorder(root.right, k);

    }

    // ---------------------- ITERATIVE APPROACH ----------------------

    // The iterative version manually simulates recursion using stack
    // Time complexity: O(H + k), where H is the height of the tree. In the worst
    // case, H can be O(N) for a skewed tree, and we may need to visit k nodes to
    // find the kth smallest element.
    // Space complexity: O(H), where H is the height of the tree. In the worst case,
    // H can be O(N) for a skewed tree, and the stack may contain all nodes in the
    // path from the root to the leftmost node.

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            k--;

            if (k == 0) {
                return root.val;
            }

            root = root.right;
        }

        return -1; // This line should never be reached if k is valid
    }

    // ------------------------------

    public static void main(String[] args) {
        int[] values = { 5, 3, 6, 2, 4, 1 };
        TreeNode root = null;
        for (int i = 0; i < values.length; i++) {
            root = BinarySearchTree.insert(root, values[i]);
        }

        int k = 3;

        System.out.println("Kth smallest element is: " + kthSmallest(root, k));
    }
}
