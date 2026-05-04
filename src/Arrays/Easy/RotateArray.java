// https://leetcode.com/problems/rotate-array/
// Given an array, rotate the array to the right by k steps, where k is non-negative.
// %n -> output will be in range of 0 to n-1
// Example: k = 3, n = 7, k % n = 3

import java.util.Arrays;

public class RotateArray {

    // Brute Force Approach
    // Time Complexity: O(n * k) - because we are rotating the array k times and
    // each rotation takes O(n) time
    // Space Complexity: O(1) - we are rotating the array in place without using

    // ------------

    // static void rotateArray(int[] nums, int k) {
    // int n = nums.length;
    // if (n == 0)
    // return; // edge case: empty array
    // k = k % n; // to handle cases where k is greater than n

    // for (int t = 0; t < k; t++) { // rotate the array k times
    // int last = nums[n - 1]; // store the last element
    // for (int i = n - 1; i > 0; i--) {
    // // nums[3] = nums[2], nums[2] = nums[1], nums[1] = nums[0]
    // nums[i] = nums[i - 1]; // shift elements to the right
    // }
    // nums[0] = last; // place the last element at the first position
    // }

    // _______________________________________________________________________

    // Optimized Approach
    // Reverse the entire array, then reverse the first k elements and finally
    // reverse
    // the remaining n-k elements.
    // Time Complexity: O(n) - we are reversing the array three times, each reversal
    // takes O(n) time
    // Space Complexity: O(1) - we are rotating the array in place without using
    // extra space

    // ------------

    static void reverse(int[] nums, int start, int end) {
        while (start < end) { // swap elements at start and end indices until they meet
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return; // edge case: empty array

        k = k % n; // to handle cases where k is greater than n
        if (k == 0)
            return; // no rotation needed if k is 0 or a multiple of n

        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateArray(nums, k);
        String s = Arrays.toString(nums);
        System.out.println(s);

    }
}