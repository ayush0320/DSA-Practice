// LC 18. 4Sum
// https://leetcode.com/problems/4sum/
// https://youtu.be/X6sL8JTROLY

// i!= j != k != l

//-------------------------------------------------------------------------------

package arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    // Similar to 3Sum, we can extend the two-pointer technique to find quadruplets
    // Sort the array and use two pointers to find pairs that sum up to the target
    // minus the current element.

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result; // Return empty list if input is null or has less than 4 elements
        }

        int n = nums.length;

        Arrays.sort(nums); // Sort the array to use two pointers

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements to avoid duplicate triplets
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // Skip duplicate elements to avoid duplicate quadruplets
                }

                int left = j + 1; // Start left pointer just after j
                int right = n - 1; // Start right pointer at the end of the array

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++; // Move left pointer to increase the sum
                    } else {
                        right--; // Move right pointer to decrease the sum
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }
}
