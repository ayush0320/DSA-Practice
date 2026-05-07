package sorting;
// Bubble Sort
// https://www.youtube.com/watch?v=1jCFUv-Xlqo&t=461s
// • A simple sorting algorithm that repeatedly steps through the list, 
//   compares adjacent elements and swaps them if they are in the wrong order. 
// • The process is repeated until the list is sorted.
// • n - 1 iterations are needed to sort n elements in the worst case.
// • adjecent elements are compared
// • largest element bubble up to the end

// Time Complexity: O(n^2) in the worst and average case, O(n) in the best case (when the array is already sorted)
// Space Complexity: O(1) (in-place sorting algorithm)

// ------------------------------------------------------------------------

public class BubbleSort {

    // static void bubble(int[] arr) {
    // int n = arr.length;
    // for (int i = 0; i < n - 1; i++) {
    // for (int j = 0; j < n - i - 1; j++) {
    // if (arr[j] > arr[j + 1]) {
    // // swap
    // int temp = arr[j];
    // arr[j] = arr[j + 1];
    // arr[j + 1] = temp;
    // }
    // }
    // }
    // }

    // ------------------------------------------------------------------------

    // Optimied - reduce swapping
    static void bubble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            boolean isSwap = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }

            if (!isSwap) {
                return; // array is sorted
            }
        }
    }

    // print after sorting
    static void print(int[] arr) {
        System.out.print("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 5, 1, 0, 9 };
        bubble(arr);
        print(arr);
    }
}
