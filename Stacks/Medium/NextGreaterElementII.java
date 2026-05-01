// LC . 503 Next Greater Element II

// Circular Array - after reaching the end of the array, we continue from the beginning.

// Pattern:
// - monotonic stack
// - circular traversal

// ------------------------------------------------------------------------

import java.util.Stack;

public class NextGreaterElementII {

    // ==================

    // Brute Force Approach:
    // Time Complexity: O(n^2) - TLE
    // Space Complexity: O(n) - for the output array

    public int[] nge(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int nextGreater = -1;

            // Check the next elements in a circular manner
            for (int j = 1; j < n; j++) {
                int circularIndex = (i + j) % n; // Circular indexing
                if (nums[circularIndex] > nums[i]) {
                    nextGreater = nums[circularIndex];
                    break;
                }
            }
            res[i] = nextGreater;
        }
        return res;
    }

    // ==================

    // Optimal Approach: Monotonic Stack
    // Visiting the array twice
    // 1. Traverse the array twice (to handle circular nature)
    // and use a stack to keep track of the next greater elements.
    // 2. For each element, pop elements from the stack
    // until the top of the stack is greater than the current element.
    // For each popped element, the current element is the next greater element.
    // i%n - to handle circular indexing.

    public int[] nge2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Start from the end of the array and traverse twice
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Get the current element using circular indexing
            int num = nums[i % n];

            // Pop elements from the stack until we find a greater element
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // If stack empty → no greater element → -1
            // Else → top of stack = next greater element
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(num);
        }

        return res;
    }

    // ==================

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };

        int[] result = new NextGreaterElementII().nge2(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
