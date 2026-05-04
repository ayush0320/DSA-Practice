// LC39

// Pattern:
// 1. Pick / Not Pick
// 2. Permutations & Combinations

// Time Complexity of recursion = Total Calls x Work Done in each call
// Time Complexity = O(2^t x k) 
// where t is the target and k is the average length of the combination
// Space Complexity = O(k) for the current combination + O(1) for the result list (excluding the space taken by the result list itself)

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, candidates, target, current, result);

        return result;
    }

    private void backtrack(int start, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]); // choose

            // not i + 1 because we can reuse the same element
            backtrack(i, nums, target - nums[i], current, result); // explore

            current.remove(current.size() - 1); // un-choose
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        System.out.println(result);
    }

}
