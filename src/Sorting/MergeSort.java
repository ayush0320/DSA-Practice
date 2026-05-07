package sorting;
// Merge Sort

// https://www.youtube.com/watch?v=cQDtOBTy7_Y
// • A divide-and-conquer algorithm that divides the input array into two halves,
//   calls itself for the two halves, and then merges the two sorted halves.
// • Recursively divides the array until it reaches arrays of size 1 (base case), which are inherently sorted.
// • Then, it merges the sorted halves back together in a sorted manner.

// Approach
// 1. Divide the array into two halves until you reach arrays of size 1.
// 2. Merge the sorted halves back together in a sorted manner.
// 3. Create a unique function to merge the two halves together.
//    - Create temporary arrays to hold the left and right halves.
//    - Use three pointers to keep track of the current index of the left half, right half, and the merged array.
// 4. Compare the elements of the left and right halves and merge them in sorted order.
// 5. Continue merging until all elements are merged back into a single sorted array.

public class MergeSort {

    static void mergeSort(int[] arr, int start, int end) {
        // base case - start index >= end index
        if (start >= end)
            return;

        int mid = end + (start - end) / 2; // to avoid overflow

        mergeSort(arr, start, mid); // sort the left half
        mergeSort(arr, mid + 1, end); // sort the right half
        merge(arr, start, mid, end); // merge the sorted halves
    }

    static void merge(int[] arr, int start, int end, int mid) {
        int n1 = mid - start + 1; // size of left half
        int n2 = end - mid; // size of right half

        // create temporary arrays to hold the left and right halves
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // merge arrays back into arr
        int i = start, j = mid + 1;

        while (i <= mid && j <= end) {
            if (leftArr[i - start] <= rightArr[j - mid - 1]) {
                arr[i] = leftArr[i - start];
                i++;
            } else {
                arr[i] = rightArr[j - mid - 1];
                j++;
            }
            i++;
        }
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
        mergeSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
