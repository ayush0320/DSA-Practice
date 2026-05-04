// Binary Tree
// - A binary tree is a heirarchical tree data structure
// - each node has at most two children.
// - Each node in a binary tree contains a value and references to its left and right children.

// DFS Traversal 
// Preorder:  Root  -> Left  -> Right
// Inorder:   Left  -> Root  -> Right
// Postorder: Left  -> Right -> Root

// BFS Traversal
// - Level Order Traversal: Level Order Treversal,
//   starting from the root and moving down to the leaves. 
// - implemented using a queue data structure.

// ------------------------------------------------------------------------
import java.util.*;

public class DefinitionOfBinaryTree {

    // Definition of a binary tree node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // --------------------

    // Method to build a binary tree from an array representation
    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // --------------------

    // Preorder Traversal: Root -> Left -> Right
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // --------------------

    // Inorder Traversal: Left -> Root -> Right
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // --------------------

    // Postorder Traversal: Left -> Right -> Root
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // --------------------

    // Level Order Traversal (BFS)
    // Queue - First In First Out (FIFO) data structure

    public static void leverOrder(Node root) {
        Queue<Node> q = new LinkedList<>(); // LinkedList implements the Queue interface
        q.add(root); // Add the root node to the queue
        q.add(null); // Add a null marker to indicate the end of the current level

        while (!q.isEmpty()) {
            if (root == null) {
                return;
            }

            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // ====================================

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root node: " + root.data);

        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
        System.out.println("Levelorder Traversal: ");
        leverOrder(root);
    }
}
