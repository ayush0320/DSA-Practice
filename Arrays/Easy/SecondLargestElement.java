import java.util.Arrays;

public class SecondLargestElement {

    // Brute Force Approach
    // Time Complexity: O(n log n) - We sort the array first, which takes O(n log n)
    // time.
    // Then we iterate through the sorted array to find the second largest element,
    // which takes O(n) time.

    // static int secondLargest(int[] arr) {
    // int n = arr.length;
    // if (arr.length < 2) {
    // return -1; // No second largest element
    // }

    // Arrays.sort(arr); // Sort the array in ascending order
    // int small = arr[0]; // Initialize small to the smallest element
    // int large = arr[n - 1]; // Initialize large to the largest element

    // for (int i = arr.length - 2; i >= 0; i--) {
    // if (arr[i] != large) { // Check if the current element is different from the
    // largest element
    // small = arr[i];
    // break;
    // }
    // }
    // return small;
    // }

    // ----------------------------------------------------------------------

    // Better Approach
    // Time Complexity: O(2n) - We iterate through the array twice: once to find the
    // largest element and once to find the second largest element. This simplifies
    // to O(n).
    static int secondLargest(int[] arr) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE; // Initialize largest to minimum value
        int secondLargest = Integer.MIN_VALUE; // Initialize second largest to minimum value

        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x > secondLargest && x != largest) {
                secondLargest = x;
            }
        }
        return secondLargest;
    }
    // ----------------------------------------------------------------------

    // Optimal Approach

    // ----------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 10, 5, 8, 12, 15, 15, 15 };
        System.out.println(secondLargest(arr));
    }
}
