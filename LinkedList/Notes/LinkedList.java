public class LinkedList {
    Node head; // head of the list
    private int size; // size of the linked list

    LinkedList() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        // Constructor to create a new node
        Node(String data) {
            this.data = data;
            this.next = null;
            size++; // increment size when a new node is created
        }
    }

    // add - first, last
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // create a new node if list is empty
            return;
        }
        newNode.next = head; // point new node to current head
        head = newNode; // update head to new node
    }

    // Add last
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

    // delete first
    public void delFirst() {
        if (head == null) {
            System.out.println("List is empty");
        }
        size--; // decrement size when a node is deleted
        head = head.next; // update head to next node
    }

    // delete last
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
// 5. Serch operation in Array List is O(1) time,
// while Linked List also requires O(n) time for search operation

// Insertion -> Linked List
// Search -> Array List

// Types of Linked Lists
// 1. Singly Linked List: Each node contains data and a pointer to the next
// node.
// 2. Doubly Linked List: Each node contains data, a pointer to the next node,
// and a pointer to the previous node.
// 3. Circular Linked List: The last node points back to the first node, forming
// a circular structure.

// head -> first node of the linked list
// tail -> last node of the linked list
