// https://youtu.be/7m1DMYAbdiY

// Push an element at the bottom of a stack using recursion.
// 1. Pop all the elements from the stack until it becomes empty.
// 2. Push the given element at the bottom of the stack.

// ------------------------------------------------------------------------

import java.util.Stack;

public class PushAtTheBottom {

    public static boolean isEmpty(Stack<Integer> s) {
        return s.size() == 0;
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (isEmpty(s)) {
            s.push(data);
            return;
        }

        int top = s.pop(); // Pop the top element
        pushAtBottom(s, data); // push the element at the bottom
        s.push(top); // Push the popped element back on top of the stack
    }

    // ==================

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 100);

        while (!s.isEmpty()) {
            System.out.println(s.peek()); // Print the top element
            s.pop(); // Remove the top element
        }
    }

}
