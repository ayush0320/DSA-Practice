package recursion.sorting;
// Selection Sort using recursion
// https://www.youtube.com/watch?v=ymgnIIclCF0&list=PLpSF79XOVa22_c7GVLAGh_-RDHOKvzvf2&index=6

public class SelectionSort {

    static void selection(int[] arr, int r, int c, int max) {
        if (r == 0)
            return;

        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c + 1, c);
            } else {
                selection(arr, r, c + 1, max);
            }
        } else {
            // Swap the max element with the last element in the current range
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            // Recursively sort the remaining elements
            selection(arr, r - 1, 0, 0);
        }
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 5, 2, 3 };
        selection(arr, arr.length, 0, 0);
        print(arr);
    }
}
