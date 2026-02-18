// https://leetcode.com/problems/maximum-subarray/description/

// Array Traversal Pattern: Single-pass scanning
// Signals -> Max/min / Running sum / Subarray basics

class MaximumSubarray {

    // Brute Force Approach
    // Time Complexity: O(n^2) - We have two nested loops, where the outer loop runs
    // n times and the inner loop also runs up to n times in the worst case.
    // Space Complexity: O(1) - We are using a constant amount of extra space to
    // store the current sum and the maximum sum, regardless of the input size.

    // ------------

    // static int maxSubarray(int[] nums) {
    // int n = nums.length;
    // int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible
    // integer

    // for (int i = 0; i < n; i++) { // starting index of the subarray
    // int currentSum = 0; // initialize sum for the current starting index
    // for (int j = i; j < n; j++) {
    // currentSum += nums[j]; // add the current element to the current sum
    // maxSum = Math.max(maxSum, currentSum); // update maxSum if currentSum is
    // greater
    // }
    // }
    // return maxSum;
    // }

    // _______________________________________________________________________

    // Optimal Approach (Kadane's Algorithm)
    // If current sum becomes negative, should we keep it? NO.
    // Because -> Negative sum reduces future total. Better to start fresh.
    // Algorithm Steps:
    // - Add current element to running sum.
    // - Update maximum.
    // - If running sum becomes negative → reset to 0.

    // ------------

    static int maxSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer
        int currentSum = 0; // Initialize currentSum to 0

        for (int num : nums) {
            currentSum += num; // Add the current element to currentSum
            maxSum = Math.max(maxSum, currentSum); // Update maxSum if currentSum is greater
            if (currentSum < 0) {
                currentSum = 0; // Reset currentSum to 0 if it becomes negative
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubarray(nums));
    }
}