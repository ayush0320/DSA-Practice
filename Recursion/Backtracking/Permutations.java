// LC46
// https://www.youtube.com/watch?v=H232aocj7bQ
// • Total number of permutations of n distinct elements is n! (n factorial).

// ------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // Time Complexity = O(n! x n)
    // where n is the number of elements in the input array and n! is the number of
    // permutations. The additional n factor comes from the time taken to create a
    // copy of the current permutation list when we add it to the result list. This
    // is because we need to create a new list for each permutation to avoid
    // reference issues.
    // Space Complexity = O(n) for the current permutation + O(1) for the result
    // list (excluding the space taken by the result list itself)

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int number : nums) {
            if (current.contains(number)) {
                continue;
            }
            current.add(number);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Permutations p = new Permutations();
        List<List<Integer>> result = p.permute(nums);
        System.out.println(result);
    }
}