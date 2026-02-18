// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.HashSet;

public class RemoveDuplicates {

    // Brute Force Approach
    // 1. Since we need store only unique elements, we can use set to store unique
    // elements and then convert it back to array
    // 2. Declare a set and insert all the elements of the array into the set.
    // 3. The number of unique elements in array is equal to size of the set.
    // 4. Traverse the set and fill the first k indices with elements in set.

    static int[] removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

    }
}
