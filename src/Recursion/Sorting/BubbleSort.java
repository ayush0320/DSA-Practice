package recursion.sorting;
// Bubble Sort using Recursion

// Time Complexity: O(n^2) - Worst and Average Case, 
// O(n) - Best Case (when the array is already sorted)
// Space Complexity: O(1) - In-place sorting

public class BubbleSort {

    static void bubble(int[] arr, int row, int col) {

        // base case
        if (row == 0) {
            return;
        }

        // inner loop - compare adjacent elements
        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                // swap
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            // move to the next column
            bubble(arr, row, col + 1);
        } else {
            // move to the next pass
            bubble(arr, row - 1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubble(arr, arr.length - 1, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
