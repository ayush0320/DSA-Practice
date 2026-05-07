package sorting;
// Quick Sort

// https://www.youtube.com/watch?v=8MNB0Mba_Dc
// • A divide-and-conquer algorithm 
// • Works by selecting a 'pivot' element from the array
//   and partitioning the other elements into two sub-arrays, 
//   according to whether they are less than or greater than the pivot.
// • The sub-arrays are then sorted recursively.
// • n - 1 iterations are needed to sort n elements in the worst case.

// Approach
// 1. Choose a pivot element from the array. (end element is commonly used)
// 2. Partition the array into two sub-arrays:
//    - Elements less than the pivot go to the left sub-array.
//    - Elements greater than the pivot go to the right sub-array.
// 3. Recursively apply the above steps to the left and right sub-arrays 
//    until the base case is reached (sub-array of size 0 or 1).
// 4. Create a unique function to partition the array 
//    and return the index of the pivot element after partitioning.

// Time Complexity: O(n log n) on average and in the best case, 
//                  O(n^2) in the worst case (when the smallest or largest element is always chosen as the pivot)
// Space Complexity: O(1) on average and in the best case, 
//                   O(n) in the worst case (due to recursive stack space when the smallest or largest element is always chosen as the pivot)

public class QuickSort {

    static void quickSort(int[] arr, int start, int end) {

        // base case - when the start index is greater than the end index,
        // it means we have a sub-array of size 0 or 1, which is already sorted.
        // use if condition to avoid infinite loop
        if (start <= end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1); // left half
            quickSort(arr, pivot + 1, end); // right half
        }

    }

    // partition function to rearrange the elements based on the pivot
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int index = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                index++;
                swap(arr, j, index);
            }
        }

        index++;
        swap(arr, end, index);
        return index;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void print(int[] arr) {
        System.out.print("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 6, 2, 1, 0, 10 };
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

}
