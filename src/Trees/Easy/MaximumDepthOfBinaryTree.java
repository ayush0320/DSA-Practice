// LC. 104. Maximum Depth of Binary Tree

//--------------------------------------------------------------

package Trees.Easy;

import java.util.LinkedList;
import java.util.Queue;

import Trees.model.TreeNode;

public class MaximumDepthOfBinaryTree {

    // Recursive Approach
    // Time Complexity: O(n) - we visit each node once
    // Space Complexity: O(h) - where h is the height of the tree, which is the
    // maximum depth of the tree.
    // In the worst case (when the tree is completely
    // unbalanced), the space complexity can be O(n).

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    // ------------------------

    // Iterativ Approach
    // - Count how many levels exist
    // - Use queue

    public static int maxDepthII(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return 0;

        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        return depth;
    }

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        // System.out.println("Max depth of tree is: " + maxDepth(root));
        System.out.println("Max depth of tree is: " + maxDepthII(root));

    }
}
