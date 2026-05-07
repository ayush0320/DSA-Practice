package linkedlist.notes;
// https://youtu.be/oAja8-Ulz6o

// Array List vs Linked List
// 1. Array List stores elements in a dynamic array,
// while Linked List stores elements in nodes that are linked together
// 2. Array List allows fast random access to elements using indices,
// while Linked List requires traversal from the head node to access elements
// 3. Array List has a fixed size that can be resized,
// while Linked List can grow and shrink dynamically as elements are added or
// removed
// 4. Insertion in Array List may require shifting elements O(n) time,
// while Linked List only requires updating node pointers O(1) time
// 5. Search operation in Array List is O(1) time,
// while Linked List also requires O(n) time for search operation
// 6. In a Linked List , entire list can be accessed from the head node,
// while in an Array List, elements can be accessed directly using indices
// 7. The entire list is connected through .next pointers in a Linked List,
// while in an Array List, elements are stored in contiguous memory locations

// Insertion -> Linked List
// Search -> Array List

// Types of Linked Lists
// 1. Singly Linked List: Each node contains data and a pointer to the next node.
// 2. Doubly Linked List: Each node contains data, a pointer to the next node, and a pointer to the previous node.
// 3. Circular Linked List: The last node points back to the first node, forming a circular structure.

// head -> first node of the linked list
// tail -> last node of the linked list

// this keyword - refers to the current instance of the class. It is used to access the members (variables and methods) 
// of the current object. It is commonly used in constructors and methods to differentiate between instance variables and parameters with the same name,
// and to call other constructors within the same class.

// ------------------------------------------------------------------------

public class LinkedList {
    Node head; // head of the list
    private int size; // size of the linked list

    // Node class representing each node in the linked list
    class Node {
        String data; // data stored in the node
        Node next; // pointer to the next node

        // Constructor to create a new node
        Node(String data) {
            this.data = data;
            this.next = null;
            size++; // increment size when a new node is created
        }
    }

    // Constructor to initialize the linked list
    LinkedList() {
        this.size = 0;
    }

    // add - first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // create a new node if list is empty
            return;
        }
        newNode.next = head; // point new node to current head
        head = newNode; // update head to new node
    }

    // add - last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // create a new node if list is empty
            return;
        }

        Node currNode = head; // assign head to currNode
        while (currNode.next != null) {
            currNode = currNode.next; // traverse to the end of the list
        }

        currNode.next = newNode; // point last node to new node
    }

    // print
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node currNode = head; // assign head to currNode
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next; // traverse to the end of the list
        }

        System.out.println("NULL");
    }

    // delete - first
    public void delFirst() {
        if (head == null) {
            System.out.println("List is empty");
        }
        size--; // decrement size when a node is deleted
        head = head.next; // update head to next node
    }

    // delete - last
    public void delLast() {
        if (head == null) {
            System.out.println("List is empty");
        }

        size--; // decrement size when a node is deleted
        if (head.next == null) {
            head = null; // only one node in the list
        }

        Node secondLast = head; // assign head to secondLast
        Node lastNode = head.next; // assign head.next to lastNode
        while (lastNode != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null; // remove reference to last node
    }

    // get size
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst("A");
        ll.addFirst("B");
        ll.addLast("C");
        ll.printList();

        // ll.delFirst();
        ll.delLast();
        ll.printList();

        System.out.println("Size: " + ll.getSize());
    }
}
