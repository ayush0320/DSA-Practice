package trees.model;

// Definition of a binary tree node
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    // Constructors for TreeNode class
    // Default constructor - initializes the value to 0 and left and right children
    // to null
    public TreeNode() {
    }

    // Constructor to initialize the value of the node
    // left and right children will be null by default
    public TreeNode(int val) {
        this.val = val;
    }

    // To initialize the value and the left and right children of the node
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(root.val); // Output: 1
        System.out.println(root.left.val); // Output: 2
        System.out.println(root.right.val); // Output: 3
    }
}
