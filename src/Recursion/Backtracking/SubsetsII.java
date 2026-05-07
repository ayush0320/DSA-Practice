package recursion.backtracking;
import java.util.ArrayList;
import java.util.Arrays;

// LC90
// • May contain duplicates
// • Key Idea:
// • Key Idea
// 1. Sort the array first
// 2. Skip duplicates during recursion
// • If this number is the same as the previous number at the same recursion level, skip it.

import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // store subsets
        List<Integer> current = new ArrayList<>(); // store the current subset being built
        Arrays.sort(nums); // sort the array to handle duplicates

        backtrack(0, nums, current, result);

        return result;
    }

    static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // INCLUDE
            current.add(nums[i]);
            // RECURSE
            backtrack(i + 1, nums, current, result);
            // BACKTRACK
            current.remove(current.size() - 1);
        }

    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(arr);
        System.out.println(result);
    }

}
