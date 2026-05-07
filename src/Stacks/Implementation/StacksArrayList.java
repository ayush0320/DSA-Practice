package stacks.implementation;
// Stacks & Queues
// https://youtu.be/7m1DMYAbdiY

// Implement a stack using a ArrayList in Java.

// ------------------------------------------------------------------------

import java.util.ArrayList;

public class StacksArrayList {
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // 1. Push an element onto the stack
        public void push(int data) {
            list.add(data);
        }

        // 2. Delete and return the top element of the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 to indicate stack underflow
            }
            int top = list.get(list.size() - 1); // Get the last element
            list.remove(list.size() - 1); // Remove the last element
            return top; // Return the removed element
        }

        // 3. Return the top element of the stack without removing it
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 to indicate stack is empty
            }
            return list.get(list.size() - 1); // Return the last element
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
