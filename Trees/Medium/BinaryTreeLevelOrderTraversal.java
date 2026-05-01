// LC. 102. Binary Tree Level Order Traversal
// https://youtu.be/EoAsWbO7sqg

// Queue - Breadth First Search

//--------------------------------------------------------------

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ------------------------

    // Time Complexity: O(n) - we visit each node once
    // Space Complexity: O(n) - in the worst case, we might have to store all nodes
    // in the queue (when the tree is completely unbalanced)

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        // Initialize a queue to keep track of nodes at each level
        // LinkedList is used here as it implements the Queue interface and provides
        // efficient insertion and removal operations
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>(); // List to store values of nodes at the current level

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);

                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }

            result.add(level);
        }

        return result;

    }

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> resuList = levelOrder(root);

        System.out.println(resuList);

    }

}
