// LC560
// Signals: HashMap, Prefix Sum

// https://www.youtube.com/watch?v=KDH4mhFVvHw

import java.util.HashMap;

public class SubarraySumEqualsK {

    // Brute Force Approach
    // Try every subarray and check if the sum is equal to k
    // Time Complexity: O(n^2) - We have two nested loops, each iterating through
    // the array.
    // Space Complexity: O(1) - We are using a constant amount of space to store
    // the sum of the subarray.

    // static int subarraySum(int[] nums, int k) {
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    // int sum = 0;
    // for (int j = i; j < nums.length; j++) {
    // sum += nums[j];
    // if (sum == k) {
    // count++;
    // }
    // }
    // }
    // return count;
    // }

    // ------------------------------------------------------------------------

    // Optimized Approach
    // Prefix sum + HashMap
    // running sum = sum from index 0 → current index
    // arr = [1, 1, 1]
    // prefixSum = [1, 2, 3]
    // 1. subarray(i+1, j) = prefixSum[j] - prefixSum[i]
    // 2. subarray(i, j) = prefixSum[j] - prefixSum[i-1]
    // 3. k = prefixSum[j] - prefixSum[i-1]
    // 4. prefixSum[i-1] = prefixSum[j] - k
    // Instead of calculating the sum of every subarray, we use cummulative sum and
    // a HashMap to store the frequency of the cumulative sums.
    // 1. Maintain running sum
    // 2. Use HashMap: key = prefix sum, value = frequency of that prefix sum
    // 3. For each prefix sum, check if (prefix sum - k) exists in the HashMap. If
    // it
    // does, it means there is a subarray that sums to k.

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // Base case: There is one way to have a sum of 0 (by taking no elements)

        int sum = 0; // This will store the cumulative sum
        int count = 0; // This will count the number of subarrays that sum to k

        for (int num : nums) {
            sum += num; // Update the cumulative sum

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // If (sum - k) exists, add its frequency to the count
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1); // Update the frequency of the current sum in the HashMap
        }

        return count; // Return the total count of subarrays that sum to k

    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        int result = subarraySum(nums, k);
        System.out.println(result);
    }
}