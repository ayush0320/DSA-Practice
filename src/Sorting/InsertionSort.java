// Insertion Sort
// https://www.youtube.com/watch?v=1jCFUv-Xlqo&t=461s
// • A simple sorting algorithm that builds the final sorted array one item at a time.
// • It iterates through the input elements and at each iteration, 
//   it removes one element from the input data, 
//   finds the location it belongs within the sorted list, and inserts it there.
// • n - 1 iterations are needed to sort n elements in the worst case.
// • if current element > [previous] element
//   current element = [previous + 1] element
// • We make space for the current element by shifting the elements.

// ------------------------------------------------------------------------

public class InsertionSort {

    static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i]; // current element
            int prev = i - 1; // previous index

            // find the correct position to insert the current element
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // insert the current element into the correct position
            arr[prev + 1] = curr;
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
        insertion(arr);
        print(arr);
    }
}
