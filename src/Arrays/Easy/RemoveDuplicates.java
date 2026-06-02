// LC 26. Remove Duplicates from Sorted Array
// Pattern: 
// Two Pointer
// -> one pointer to read
// -> one pointer to write

//----------------------------------------------------------------------------------------

package arrays.easy;

import java.util.ArrayList;

public class RemoveDuplicates {

    // ---------------------BRUTE FORCE APPROACH---------------------
    // 1. Since we need store only unique elements, we can use set to store unique
    // elements and then convert it back to array
    // 2. Declare a set and insert all the elements of the array into the set.
    // 3. The number of unique elements in array is equal to size of the set.
    // 4. Traverse the set and fill the first k indices with elements in set.

    // Time Complexity: O(n) to traverse the array and O(n) to traverse the set, so
    // overall O(n)
    // Space Complexity: O(n) to store the unique elements in the set

    static int removeDuplicates(int[] nums) {
        ArrayList<Integer> set = new ArrayList<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        // Fill the first k indices with elements in set
        for (int i = 0; i < set.size(); i++) {
            nums[i] = set.get(i);
        }

        return set.size();
    }

    // ---------------------OPTIMAL APPROACH---------------------
    // 1. Since the array is sorted, we can use two pointers to keep track of the
    // current element and the next element.
    // 2. If the current element is not equal to the next element, we can move the
    // next element to the next position of the current element and move the
    // current element to the next position.
    // 3. We can keep track of the number of unique elements in the array and return
    // it at the end.

    // Time Complexity: O(n) to traverse the array
    // Space Complexity: O(1) since we are not using any extra space

    public static int removeDuplicatesII(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1; // to keep track of the number of unique elements

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // move the next element to the next position of the current element
                k++; // move the next element to the next position of the current element
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };

        int k = removeDuplicatesII(nums);
        System.out.println(k);
    }
}
