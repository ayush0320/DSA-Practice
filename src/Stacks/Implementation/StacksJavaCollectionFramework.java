package stacks.implementation;
// Stacks & Queues
// https://youtu.be/7m1DMYAbdiY

// Implement a stack using the Java Collection Framework.

// ------------------------------------------------------------------------

import java.util.Stack;

public class StacksJavaCollectionFramework {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
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
