// LC34. Find First and Last Position of Element in Sorted Array
//https://www.youtube.com/watch?v=hjR1IYVx9lY&list=PLF6ChxadzFf8vjafLIxxbKUfarW4V4IOh&index=3

public class FindFirstAndLastPositionOfElement {

    // Brute Force Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    // static int[] searchRange(int[] nums, int target) {
    // int first = -1;
    // int last = -1;

    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] == target) {
    // if (first == -1) {
    // first = i;
    // } else {
    // last = i;
    // }
    // }
    // }

    // return new int[] { first, last };
    // }

    // ------------------------------------------------------------------------

    // Optimal Approach: Binary Search
    // Time Complexity: 2 x O(log n) - O(log n) for finding the first occurrence and
    // O(log n) for finding the last occurrence

    static int[] searchRange(int[] nums, int target) {
        int first = firstOccurance(nums, target);
        int last = lastOccurance(nums, target);
        return new int[] { first, last };
    }

    static int firstOccurance(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                first = mid;
                high = mid - 1; // Continue searching in the left half for the first occurrence
            } else if (nums[mid] < target) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return first;
    }

    static int lastOccurance(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                last = mid;
                low = mid + 1; // Continue searching in the right half for the last occurrence
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        // int[] nums = { 1 };
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
