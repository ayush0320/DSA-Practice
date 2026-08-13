package arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        // Brute Force Approach
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[i] == nums[j]) {
        // return true;
        // }
        // }
        // }

        // return false;

        // ----------------------------------------------------------------------

        // Hash set - no duplicates allowed
        // Order is not implied in hash set
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // seen is a HashSet — a set that automatically avoids duplicate elements
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num); // Add the number to the set
            // System.out.println(seen);
        }

        return false;
    }

    // ----------------------------------------------------------------------

    // Return array of duplicate values.

    public static ArrayList<Integer> findDuplicates(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                list.add(arr[i]);
            } else {
                map.put(arr[i], i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }
}