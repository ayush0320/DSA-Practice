package stacks.easy;
// LC. 20 Valid Parenthesis
// https://youtu.be/TaWs8tIrnoA

// Pattern: Stack
// - matching pairs
// - nested structure
// - last opened should close first

// Open brackets - push
// Close brackets - pop and check

// We use Java Collections Stack class to implement the stack data structure.
// The Stack class provides methods like push(), pop(), peek(), and isEmpty() to perform stack operations.

// toCharArray() - used to convert the input string into a character array.

// ------------------------------------------------------------------------

import java.util.Stack;

public class ValidParenthesis {

    // 1. For every opening bracket, push it onto the stack.
    // 2. For every closing bracket, check if the stack is empty.
    // If it is, return false (unmatched closing bracket).
    // 3. If the stack is not empty, pop the top element and check
    // if it matches the corresponding opening bracket for the current closing
    // bracket.
    // If it doesn't match, return false.
    // 4. After processing all characters, check if the stack is empty.
    // If it is empty, return true (all brackets are matched);
    // otherwise, return false (unmatched opening brackets remain).

    // Time Complexity: O(n) - We traverse the input string once.
    // Space Complexity: O(n) - In the worst case, we may push all opening brackets
    // onto the stack.

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Open brackets - push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Close brackets - pop and check
            else {

                // if there's no corresponding opening bracket
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                // if the popped element matches the corresponding opening bracket
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Check if the stack is empty at the end
        return stack.isEmpty();

    }

    // ==================

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s)); // Output: true
    }
}