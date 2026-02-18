//LC33 - Search in Rotated Sorted Array

public class SearchInRotatedSortedArray {

    // Brute Force Approach
    // Linear search through the array to find the target element.
    // Time Complexity: O(n) - we may have to check each element in the worst case
    // Space Complexity: O(1) - we are not using any extra space

    static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1; // target not found
    }

    // ------------------------------------------------------------------------

    // Binary Search Approach
    // Identify the sorted half of the array and perform binary search on that half.

    static i

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        // int result = linearSearch(nums, target);
        int result = binarySearch(nums, target);
        System.out.println(result);
    }

}
