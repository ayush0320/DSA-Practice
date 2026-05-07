package stacks.easy;
// LC . 496 Next Greater Element I
// Monotonic Stack - https://youtu.be/mcOXqqX6D54
// Solution - https://youtu.be/8BDKB2yuGyg

// Pattern Signals:
// - next greater element
// - next smaller element
// - nearest greater/smaller

// Montonic Stack:
// - A stack that maintains its elements in a specific order (either increasing or decreasing).

// ------------------------------------------------------------------------

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    // Brute Force Approach:
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) - for the output array

    // ==================

    // Optimal Approach: Monotonic Stack
    // 1. Traverse nums2 and use a stack to keep track of the next greater elements.
    // 2. For each element in nums2, pop elements from the stack
    // until the top of the stack is greater than the current element.
    // For each popped element, the current element is the next greater element.
    // 3. Store the next greater elements in a map for quick lookup.
    // 4. Finally, build the result for nums1 using the map.
    // Time Complexity: O(n) - each element is pushed and popped at most once
    // Space Complexity: O(n) - for the stack and the map

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: process nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // 2. build the result for nums1 using the map
        // getOrDefault() - retrieve the value associated with a specified key.
        // If the key is not found in the map, it returns the default value provided as
        // the second argument.
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    // ==================

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] result = new NextGreaterElement().nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
