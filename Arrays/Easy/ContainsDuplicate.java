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

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }
}