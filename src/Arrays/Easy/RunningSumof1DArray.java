//LC1480
// Pattern - Prefix Sum
// Signals: 
// ✅ Subarray sum
// ✅ Prefix Sum
// ✅ Range query
// ✅ Cumulative total

import java.util.Arrays;

public class RunningSumof1DArray {

    // Brute Force Approach
    // Time Complexity O(n) - We iterate through the array once to calculate the
    // running sum.
    // Space Complexity O(1) - We are modifying the input array in place, so we are
    // not using any extra space.

    static int[] runningSum(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result));
    }
}
