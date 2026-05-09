// LC 236. Lowest Common Ancestor of a Binary Tree
// https://youtu.be/_-QHfMDde90
// Pattern -> DFS, Recursion
// -> Ancestor: every parent node that exists in the path 
// from node n up to root
// -> A node can be it's own ancestor
// -> p.val != q.val

//--------------------------------------------------------------

package trees.medium;

import trees.model.TreeNode;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }

    // ========================
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode result = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("LCA: " + result);
    }
}
