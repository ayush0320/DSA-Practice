//LC33 - Search in Rotated Sorted Array
// Understanding boundary logic
//https://www.youtube.com/watch?v=6WNZQBHWQJs

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
    // Pivot - the point where the array is rotated, which can be found by comparing
    // the middle element with the leftmost element.
    // If the middle element is greater than or equal to the leftmost element, then
    // the left half is sorted. Otherwise, the right half is sorted.
    // Time Complexity: O(log n) - we are halving the search space in each step
    // Space Complexity: O(1) - we are not using any extra space

    static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // search in the left half
                } else {
                    left = mid + 1; // search in the right half
                }
            } else {
                // right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // search in the right half
                } else {
                    right = mid - 1; // search in the left half
                }
            }
        }
        return -1; // target not found
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        // int result = linearSearch(nums, target);
        int result = binarySearch(nums, target);
        System.out.println(result);
    }

}
