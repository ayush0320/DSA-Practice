// Stacks & Queues
// https://youtu.be/7m1DMYAbdiY

// Implement a stack using a linked list in Java.

// -> A stack is a data structure that follows the Last In First Out (LIFO) principle.
// -> The last element added to the stack is the first one to be removed.
// -> It can be implemented using arrays or linked lists.

// Common operations include - 
// 1. push (): Add an element to the top of the stack. O(1)
// 2. pop (): Remove the top element from the stack. O(1)
// 3. peek (): View the top element without removing it. O(1)
// 4. isEmpty (): Check if the stack is empty. O(1)

// Ways to implement a stack -
// 1. Using an array - 
//    - Fixed size, can lead to overflow if the stack exceeds the defined size.
//    - Not usually used.
// 2. ArrayList - 
//    - Dynamic size, can grow as needed, but may have overhead due to resizing.
// 3. Using a linked list -
//    - Dynamic size, can grow and shrink as needed.
//    - May use more memory due to storing additional pointers.

// ------------------------------------------------------------------------

public class Stacks {

    // Node class to represent each element in the stack
    // "this" keyword refers to the current instance of the class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node head;

        // Check if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // 1. Push an element onto the stack
        public void push(int data) {
            Node newNode = new Node(data);

            // If the stack is empty, set the new node as the head
            if (isEmpty()) {
                head = newNode;
                return;
            }
            // Otherwise, link the new node to the current head and update the head
            newNode.next = head;
            head = newNode;
        }

        // 2. Delete and return the top element of the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 to indicate stack underflow
            }
            int top = head.data;
            head = head.next; // Move the head to the next node
            return top;
        }

        // 3. Return the top element of the stack without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 to indicate stack is empty
            }
            return head.data; // Return the data of the top element
        }
    }

    // ==================

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Print the top element
            s.pop(); // Remove the top element
        }
    }
}
