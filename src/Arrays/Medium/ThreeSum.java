// LC 15. 3Sum 
// https://leetcode.com/problems/3sum/description/
//https://youtu.be/cRBSOz49fQk

// i!= j != k

//-------------------------------------------------------------------------------

package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // BRUTE FORCE APPROACH
    // Time Complexity = O(n^3) - We have three nested loops, where each loop runs
    // up to n times in the worst case.
    // Space Complexity = O(1) - We are using a constant amount of extra space to
    // store the triplet and the result list.

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }

    // --------------------------------------

    // OPTIMAL APPROACH
    // We first sort the array and then use a two-pointer technique
    // to find pairs that sum up to the negative of the current element.
    // This way, we can efficiently find triplets that sum to zero.
    // Time Complexity = O(n^2) - The outer loop runs n times, and the inner while
    // loop runs at most n times in total for each iteration of the outer loop.
    // Space Complexity = O(1) - We are using a constant amount of extra space

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(); // Return empty list if input is null or has less than 3 elements
        }

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Sort the array to use two pointers

        // n -2 because we need at least two more elements after i to form a triplet
        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements to avoid duplicate triplets
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is zero, we found a triplet. We add it to the result list.
                if (sum == 0) {
                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]));
                }
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    // --------------------------------------

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, 4 };
        List<List<Integer>> triplets = solution.threeSum2(nums);
        System.out.println(triplets);
    }
}
