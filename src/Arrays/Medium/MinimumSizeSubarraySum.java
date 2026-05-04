// LC209
// Sliding Window (Variable Size)
// Signals: Sliding Window, Two Pointers
// ✅ contiguous subarray
// ✅ minimum length
// ✅ sum condition
// ✅ positive numbers

public class MinimumSizeSubarraySum {

    // Brute Force Solution:
    // Try every subarray and check if the sum is greater than or equal to target

    // ------------------------------------------------------------------------

    // Optimal Solution:
    // Try every subarray and check if the sum is greater than or equal to target
    // Sliding Window:
    // RIGHT pointer = add new elements
    // LEFT pointer = remove old elements
    // Time Complexity: O(n) - Each element is visited at most twice (once when
    // added and once when removed)
    // Space Complexity: O(1)

    static int minSubarrayLen(int[] nums, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE; // Initialize minLength to a large value

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right]; // expand

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1); // update minLength
                sum -= nums[left]; // shrink
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength; // If minLength is unchanged, return 0
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(minSubarrayLen(nums, target));
    }
}
