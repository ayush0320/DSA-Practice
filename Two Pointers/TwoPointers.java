// Patterns 

public class TwoPointers {
    // 1. Constant Window
    static void sumOfK(int[] arr, int k) {
        int left = 0;
        int right = k - 1;
        while (right < arr.length) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += arr[left + i];
            }
            System.out.println("Sum of " + k + " elements: " + sum);
            left++;
            right++;
        }

    }

    // ----------------------------------------------------------------------

    // 2. Longest subarray/substring <Condition>
    // Q. Find the longest subarray with sum less than or equal to k
    // i. Brute Force: O(n^2) - Check all subarrays and calculate their sum
    static void LongestSubarray(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum <= k) {
                    max = Math.max(max, j - i + 1); // Update max length
                }
            }
        }
    }

    // ii. Better Approach
    // Time Complexity: O(2n) - Each element is visited at most twice (once when
    // expanding the window and once when shrinking it).
    static void LongestSubarryay2(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0; // window size
        while (right < n) {
            sum += arr[right]; // Expand the window to the right
            while (sum > k) {
                sum = sum - arr[left]; // Shrink the window from the left
                left++;
            }
            if (sum <= k) {
                max = Math.max(max, right - left + 1); // Update max length
            }
            right++;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 3;
        sumOfK(arr, k);
    }
}
