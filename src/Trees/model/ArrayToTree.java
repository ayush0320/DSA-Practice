// -> Java program that takes an array in preorder traversal
// -> Uses -1 to represent null
// -> Builds binary tree using recurssion

//--------------------------------------------------------------

package trees.model;

public class ArrayToTree {

    static int index = -1;

    public static TreeNode buildTree(int nodes[]) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }

        // Create a new node with the current value
        TreeNode newNode = new TreeNode(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTree(nodes);
        System.out.println(root.val);
    }
}
