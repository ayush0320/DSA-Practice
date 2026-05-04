// LC35
// Binary Search
// Return the index if the target is found. 
// If not, return the index where it would be if it were inserted in order.
// Return low if the target is not found, 
// as low will be the index where the target can be inserted while maintaining the sorted order of the array.

// Time Complexity: O(log n)
// Space Complexity: O(1)

public class SerchInsertPosition {

    static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
