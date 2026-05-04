// Sliding Window (Basic)
// Signals: Continuous subarray/substring
// Longest/shortest length

// Key signals:
// ✅ contiguous subarray
// ✅ fixed size window (length = k)
// ✅ maximize/minimize

public class MaximumAverageSubarray {

    // Brute Force Approach
    // static double findMaxAverage(int[] nums, int k) {
    // double maxAvg = -Double.MAX_VALUE; // Extremely small number (almost negative
    // infinity).
    // This ensures that any average calculated will be greater than this initial
    // value.
    // We iterate through the array, starting from each index up to nums.length - k
    // (to ensure we have enough elements for a full window of size k). For each
    // starting index, we calculate the sum of the next k elements and then compute
    // the average. We compare this average with the current maxAvg and update
    // maxAvg if the new average is greater. Finally, we return the maximum average
    // found after checking all possible windows of size k.
    // The time complexity of this approach is O(n * k) because we have to calculate
    // the sum for each window of size k, and there are O(n) such windows. The space
    // complexity is O(1) since we are using only a constant amount of extra space.

    // for (int i = 0; i < nums.length - k; i++) {
    // int sum = 0; // Reset sum for each starting point of the window.
    // for (int j = i; j < i + k; j++) {
    // sum += nums[j]; // Add the next element in the window to the sum.
    // }
    // double avg = (double) sum / k; // Calculate the average for the current
    // window.
    // maxAvg = Math.max(maxAvg, avg); // Update maxAvg if the current average is
    // greater.
    // }
    // return maxAvg; // Return the maximum average found.
    // }

    // ------------------------------------------------------------------------

    // Optimal Approach (Sliding Window)
    // First we calculate the sum of the first k elements to initialize our window
    // sum. Then, we iterate through the array starting from the k-th element (index
    // k) to the end of the array. For each new element, we add it to the window sum
    // and subtract the element that is sliding out of the window (the element at
    // index i - k). This way, we maintain the sum of the current window of size k
    // without having to recalculate it from scratch. After updating the window sum,
    // we calculate the average and compare it with the current maximum average,
    // updating it if necessary. Finally, we return the maximum average found. The
    // time complexity of this approach is O(n) because we traverse the array once,
    // and the space complexity is O(1) since we are using only a constant amount of
    // extra space.

    static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0; // This variable will hold the sum of the current window of size k.

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i]; // Calculate the sum of the first k elements to initialize the window sum.
        }

        int maxSum = windowSum; // Initialize maxSum with the sum of the first window.

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // Add the new element and remove the element that is sliding out of the
                                                // window.
            maxSum = Math.max(windowSum, maxSum); // Update maxSum if the current window sum is greater.
        }
        return (double) maxSum / k; // Return the maximum average found by dividing maxSum by k.
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
