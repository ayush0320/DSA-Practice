import java.util.HashMap;
import java.util.Map;

// Pattern -> 
// HashMap / HashSet / Frequency counting
// Use when: Find duplicates / Count elements / Fast lookup

public class TwoSum {

    // Brute Force Approach
    // Time Complexity: O(n^2) - We have two nested loops, each iterating through
    // the array.

    // public static int[] twoSum(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i; j < nums.length; j++) {
    // if (nums[i] + nums[j] == target) {
    // return new int[] { i, j };
    // }
    // }
    // }

    // return new int[] {};
    // }

    // ----------------------------------------------------------------------

    // Two Pointer Approach
    // Array has to be sorted
    // Time complexity: O(n log n) - We sort the array first, which takes O(n log n)
    // time. Then we use the two-pointer technique, which takes O(n) time.

    // public static int[] twoSum(int[] nums, int target) {
    // int n = nums.length;
    // int left = 0; // left pointer
    // int right = n - 1; // right pointer

    // while (left < right) {
    // int sum = nums[left] + nums[right];

    // if (sum == target) {
    // return new int[] { left, right }; // return the indices of the two numbers
    // } else if (sum < target) {
    // left++; // move left pointer to the right to increase the sum
    // } else {
    // right--; // move right pointer to the left to decrease the sum
    // }
    // }
    // return new int[] {}; // return empty array if no solution is found
    // }

    // ----------------------------------------------------------------------

    // Hash Map Approach
    // 1. Search for comlement of each element in the hash map.
    // 2. If found, return the indices of the two numbers.
    // 3. Store the numbers arr[i] and their indices in a hash map.
    // - O(1) average time complexity lookups.
    // - This allows us to find the complement of each number efficiently.
    // - Element - key and Index - value

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (map.containsKey(complement)) { // If the complement exists in the map, we found a solution
                return new int[] { map.get(complement), i };
            }
            map.put(num, i); // Store the current number and its index in the map for future reference
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6, 5, 3, 2, 1 };
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
