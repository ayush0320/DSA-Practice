// LC 543. Diameter of a Binary Tree
// Diameter - number of edges on the longest path between two nodes in a tree.

//--------------------------------------------------------------

package trees.easy;

import trees.model.TreeNode;

public class DiameterOfABinaryTree {

    // At every node:
    // diameter = left_height + right_height

    static int diameter = 0;

    public static int diameterOfABinaryTree(TreeNode root) {
        height(root); // we call height to update the diameter at every node
        return diameter;
    }

    private static int height(TreeNode node) {

        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right); // Update the diameter at every node

        return 1 + Math.max(left, right); // Return the height of the current node
    }

    // ------------------------

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println("Diameter: " + diameterOfABinaryTree(root));

    }
}