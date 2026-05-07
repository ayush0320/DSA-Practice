package recursion.backtracking;
// LC 78. Subsets
// https://www.youtube.com/watch?v=pNzljlzDCiI

// • Subsets of the string "abc" are: "", "a", "b", "c", "ab", "ac", "bc", and
// "abc".
// • Non-adjacent collection of characters from the string.
// • Order is conserved.
// • Does not contain duplicates.
// • Subsequence:
// 1.Subsets - arrays
// 2.Substring - strings
// • Total subsets = 2^n, where n is the length of the input string

// Pattern:
// 1. Pick / Not Pick
// 2. Permutations & Combinations

// Approach:
// Backtracking - a recursive algorithm for solving problems by trying to build
// a solution incrementally, one piece at a time, and removing those solutions
// that fail to satisfy the constraints of the problem at any point in time
// (backtrack).
// 1. Solve for a single character and then apply the same logic for the rest of
// the characters
// 2. Choices for every character: include it in the subset or exclude it
// 3. Create an answer list to store the subsets
// 4. index i = 0, used to keep track of the current position in the input
// string

// Time Complexity of recursion = Total Calls x Work Done in each call
// Time Complexity = O(2^n x n)

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static void printSubsets(int[] arr, List<Integer> ans, int i) {
        if (i == arr.length) {
            // print the subset
            System.out.println(ans);
            return;
        }

        // INCLUDE
        // add the current element to the subset and move to the next element
        ans.add(arr[i]);
        printSubsets(arr, ans, i + 1);

        // BACKTRACK
        // remove the last element added to the subset to explore other possibilities
        ans.remove(ans.size() - 1); // remove the last element added to the subset

        // EXCLUDE
        // do not add the current element to the subset and move to the next element
        printSubsets(arr, ans, i + 1);
    }

    // ------------------------------------------------------------------------

    // Backtracking approach with a separate function - include and exclude cases
    // current- stores the current subset being built | path of the recursion tree
    // result - stores all the subsets generated

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // store subsets
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    static void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // add the current subset to the result list

        for (int i = start; i < nums.length; i++) {
            // INCLUDE
            current.add(nums[i]); // add the current element to the subset

            // RECURSE
            backtrack(i + 1, nums, current, result); // move to the next element

            // BACKTRACK
            current.remove(current.size() - 1); // remove the last element added to the subset
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<Integer> ans = new ArrayList<>();
        printSubsets(arr, ans, 0);
    }
}
