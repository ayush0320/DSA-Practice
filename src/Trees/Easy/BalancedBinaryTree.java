// LC. 110 Balanced Binary Tree
// -> Balanced Tree - a binary tree in which the difference 
// between the heights of the left and right subtrees is 
// no more than one for every node in the tree.
// -> The height of the tree is logarithmic O(log n) 
// with respect to the number of nodes (n).
// -> For every node:
// |height(left subtree) - height(right subtree)| ≤ 1

//--------------------------------------------------------------

package Trees.Easy;

import Trees.model.TreeNode;

public class BalancedBinaryTree {

    // Recursive Approach

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

    }

    // ========================

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }
}
