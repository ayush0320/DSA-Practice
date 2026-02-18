import java.util.HashMap;

//LC523
// Pattern - Prefix Sum
// Signals: 
// ✅ Subarray sum
// ✅ Prefix Sum
// ✅ Range query
// ✅ Cumulative total

// https://www.youtube.com/watch?v=OKcrLfR-8mE

public class ContinuousSubarraySum {

    // Brute Force Approach
    // Time Complexity: O(n^2) - !Time Limit Exceeded
    // Space Complexity: O(1)
    // This method checks all possible subarrays and calculates their sums to
    // determine if any of them are divisible by k.

    // static boolean checkSubarraySum(int[] nums, int k) {

    // for (int start = 0; start < nums.length; start++) {
    // int sum = 0;
    // for (int end = start; end < nums.length; end++) {
    // sum += nums[end];
    // if (sum % k == 0 && end - start >= 1) {
    // return true;
    // }
    // }
    // }
    // return false;
    // }

    // ------------------------------------------------------------------------

    // Optimal Approach
    // Using running sum (prefix sum) and a
    // HashMap to store the remainders of the running sum when divided by k.
    // Algorithm:
    // 1. Keep cumulative sum.
    // 2. Compute remainder = sum % k.
    // 3. If same remainder seen before:
    // - check distance ≥ 2, if yes, return true.
    // - else return false.
    // key = remainder, value = index of first occurrence of this remainder.

    static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // To handle the case when the subarray starts from index 0

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 0, 0, 0 };
        int k = 3;
        System.out.println(checkSubarraySum(nums, k)); // Output: true
    }
}
