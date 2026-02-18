// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
// Given an array of distinct integers, return true if the array was originally sorted in non-decreasing order, 
// then rotated some number of positions (including zero). Otherwise, return false.

// _______________________________________________________________________

public class CheckSortedOrRotated {

    // Brute Force Approach
    // Try every index as the starting point and check if the array is sorted in
    // non-decreasing order
    // In a rotated array check, we read like:
    // start, start+1, start+2, ...
    // but if we pass n-1 (last index), the next should become 0 (first index).
    // % n does exactly that.

    // ------------

    // Optimal Approach
    // Count the number of times the order is violated (i.e., nums[i] > nums[i + 1])
    // If the count is more than 1, then the array is not sorted and rotated
    // Time Complexity: O(n) - we are traversing the array once
    // Space Complexity: O(1) - we are using only a constant amount of space
    static boolean check(int[] nums) {
        int n = nums.length;
        int count = 0; // to count the number of times the order is violated

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) { // if current element is greater than the next element, order is violated
                count++;
            }
            if (count > 1) {
                return false; // if order is violated more than once, it's not sorted and rotated
            }
        }
        return true; // if order is violated at most once, it's sorted and rotated
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));
    }
}
