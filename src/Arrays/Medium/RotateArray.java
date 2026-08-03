// LC 189. Rotate Array
// https://leetcode.com/problems/rotate-array

package arrays.medium;

public class RotateArray {

    // BRUTE FORCE APPRAOCH
    // Rotate One by One - O(n * d) Time and O(1) Space

    // Function to left rotate array by d positions
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;

        // Repeat the rotation d times
        for (int i = 0; i < d; i++) {

            // Left rotate the array by one position
            int first = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = first;
        }
    }

    // OPTIMAL APPROACH
    // Reversal Algorithm - O(n) Time and O(1) Space

    static void rotate(int[] nums, int d) {
        int n = nums.length;
        d = d % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, d - 1);
        reverse(nums, d, n - 1);
    }

    static void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotate(arr, d);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
