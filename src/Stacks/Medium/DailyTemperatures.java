package stacks.medium;
// LC . 739 Daily Temperatures
// https://youtu.be/ekFs9Nb2RNQ

// Pattern: 
// → monotonic stack
// → next greater element
// → we store indices not values in stack because we need distance

// ------------------------------------------------------------------------

import java.util.Stack;

public class DailyTemperatures {

    // Brute Force Approach
    // Time Complexity: O(n^2) - TLE
    // Space Complexity: O(n) - for the output array

    public int[] dt(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    // ==================

    // Optimal Approach: Monotonic Stack
    // 1. Traverse the array from the end and use a stack to keep track of the next
    // greater elements.
    // 2. For each element, pop elements from the stack until the top of the stack
    // is greater than the current element.
    // For each popped element, the current element is the next greater element.

    public int[] dt2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Start from the end of the array and traverse backwards
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from the stack until we find a greater element
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                stack.pop();
            }

            // If the stack is not empty,
            // the top of the stack is the index of the next greater element
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return res;
    }

    // ==================

    // Another way to implement the optimal approach
    // 1. Traverse the array from the beginning and use a stack to keep track of the
    // indices of the elements.
    // 2. For each element, pop elements from the stack until the top of the stack
    // is greater than the current element.
    // 3. For each popped element, the current element is the next greater element.
    // 4. The distance is calculated as the difference between the current index and
    // the popped index.

    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return res;
    }

    // ==================

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = new DailyTemperatures().dt2(temperatures);
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
