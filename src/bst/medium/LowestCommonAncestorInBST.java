// LC 235. Lowest Common Ancestor of a Binary Search Tree

package bst.medium;

import bst.BinarySearchTree;
import bst.BinarySearchTree.TreeNode;

public class LowestCommonAncestorInBST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val > root.val) {
            return root;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;

    }

    public static void main(String[] args) {
        int[] values = { 6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5 };
        TreeNode root = null;
        for (int i = 0; i < values.length; i++) {
            root = BinarySearchTree.insert(root, values[i]);
        }
        TreeNode p = root.left;
        TreeNode q = root.right;
        TreeNode ans = lowestCommonAncestor(root, q, p);
        System.out.println(ans.val);
    }
}
