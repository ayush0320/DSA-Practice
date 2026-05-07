// LC 100. Same Tree
// Two binary trees are considered the same if they are structurally identical,
// and the nodes have the same value.

//--------------------------------------------------------------

package trees.easy;

import trees.model.TreeNode;

public class SymmetricTree {

    // left subtree vs right subtree (mirror comparison)

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return (isMirror(left.left, right.right) && isMirror(left.right, right.left));
    }

    // ========================

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(3);
        p.right.right = new TreeNode(4);

        System.out.println("Is symmetric? " + isSymmetric(p));
    }

}
