// LC704

// Time Complexity: O(log n) - Binary Search
// n -> n/2 -> n/4 -> n/8 -> ... -> 1 = log n
// Binary search works only on sorted arrays
// BS is a divide and conquer algorithm
// BS is very optimized
// Space Complexity: O(1) - Constant space

public class BinarySearch {

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // int mid = (left + right) / 2;
            // To avoid potential overflow, we can calculate mid as follows:
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }
}
