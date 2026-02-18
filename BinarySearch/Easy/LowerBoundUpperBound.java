public class LowerBoundUpperBound {

    // Lower Bound - smallest index suck that nums[index] >= target
    // Q - Given a sorted array of integers and a target value,
    // find the index of the first occurrence of the target in the array.
    // If the target is not found, return -1.
    // May or may not be an answer
    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    static int lowerBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2; // to avoid overflow

            if (nums[mid] >= target) {
                ans = mid; // potential answer
                high = mid - 1; // search in the left half
            } else {
                low = mid + 1; // search in the right half
            }
        }

        return ans == n ? -1 : ans; // if ans is n, it means target is greater than all elements in the array
    }

    // ------------------------------------------------------------------------

    // Upper Bound - smallest index such that nums[index] > target
    // Q - Given a sorted array of integers and a target value,
    // find the index of the first element that is greater than the target in the
    // array.
    // If such an element does not exist, return -1.

    static int upperBound(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                ans = mid; // potential answer
                low = mid + 1;
            }
        }
        return ans == n ? -1 : ans;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
        int target = 9;
        System.out.println("Lower Bound: " + lowerBound(nums, target));
        System.out.println("Upper Bound: " + upperBound(nums, target));
    }
}
