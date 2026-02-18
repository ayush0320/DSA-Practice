// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

// Pattern: Two Pointers
// Signals -> Sorted array / Pair finding / Shrinking window

public class TwoSumII {

    // Brute Force Approach
    // Time Complexity: O(n^2) - We have two nested loops, where the outer loop runs
    // n times and the inner loop also runs up to n times in the worst case.

    // ------------

    // static int[] twoSum(int[] nums, int target) {
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] { i + 1, j + 1 }; // Return 1-based indices
    // }
    // }
    // }
    // return new int[] { -1, -1 }; // Return [-1, -1] if no solution is found
    // }

    // _______________________________________________________________________

    // Optimal Approach
    // Because array is sorted:
    // Small numbers on left
    // Large numbers on right
    // If sum < target -> Move left pointer to right (to increase sum)
    // If sum > target -> Move right pointer to left (to decrease sum)

    // ------------

    static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 }; // Return [-1, -1] if no solution is found

    }

    // _______________________________________________________________________

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + ", " + result[1]);

    }
}
