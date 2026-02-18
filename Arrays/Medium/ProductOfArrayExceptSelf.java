import java.util.Arrays;

// LC238
// O(n) time complexity
// No division allowed
// https://www.youtube.com/watch?v=TW2m8m_FNJE

// Sliding Window

public class ProductOfArrayExceptSelf {

    // Brute Force Approach
    // Time Complexity: O(n^2) - !Time Limit Exceeded
    // Space Complexity: O(n) - for the result array
    // static int[] productOfArray(int[] nums) {
    // int[] result = new int[nums.length];

    // for (int i = 0; i < nums.length; i++) {
    // int product = 1;
    // for (int j = 0; j < nums.length; j++) {
    // if (i != j) {
    // product *= nums[j];
    // }
    // }
    // result[i] = product;
    // }

    // return result;
    // }

    // ------------------------------------------------------------------------

    // Optimal Approach
    // result[i] = product of left side of i * product of right side of i
    // result[i] = product of elements [0 -> i-1] * product of elements [i+1 -> end]

    static int[] productOfArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. Calculate prefix - left product
        result[0] = 1; // No elements to the left of the first element

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1]; // prefix[i] = product of elements from index 0 to i-1
        }

        // 2. Calculate suffix - right product and multiply with prefix
        int suffix = 1; // To store the product of elements to the right of the current index

        for (int i = n - 2; i >= 0; i--) {
            suffix = suffix * nums[i + 1]; // suffix = product of elements from index i+1 to end
            result[i] = result[i] * suffix; // result[i] = prefix[i] * suffix
        }

        return result;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productOfArray(nums);
        System.out.println(Arrays.toString(result));
    }
}
