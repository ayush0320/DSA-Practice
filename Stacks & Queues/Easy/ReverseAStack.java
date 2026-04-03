// https://youtu.be/7m1DMYAbdiY

// ------------------------------------------------------------------------

import java.util.Stack;

public class ReverseAStack {

    public static boolean isEmpty(Stack<Integer> s) {
        return s.size() == 0;
    }

    // Function to push an element at the bottom of a stack using recursion.
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (isEmpty(s)) {
            s.push(data);
            return;
        }

        int top = s.pop(); // Pop the top element
        pushAtBottom(s, data); // push the element at the bottom
        s.push(top); // Push the popped element back on top of the stack
    }

    // Function to reverse a stack using recursion.
    public static void reverseStack(Stack<Integer> s) {
        if (isEmpty(s)) {
            return;
        }

        int top = s.pop(); // Pop the top element
        reverseStack(s); // Reverse the remaining stack
        pushAtBottom(s, top); // Push the popped element at the bottom of the reversed
    }

    // ==================

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        reverseStack(s);

        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Print the top element
            s.pop(); // Remove the top element
        }
    }
}
