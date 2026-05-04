// Selection Sort
// https://www.youtube.com/watch?v=1jCFUv-Xlqo&t=461s
// • A simple sorting algorithm that divides the input list into two parts:
//   the sorted part at the left end and the unsorted part at the right end.
// • Initially, the sorted part is empty and the unsorted part is the entire list.
// • The algorithm repeatedly selects the smallest (or largest, depending on sorting order) 
//   element from the unsorted part and moves it to the end of the sorted part.
// • n - 1 iterations are needed to sort n elements in the worst case.
// • non-adjecent elements are compared

// ------------------------------------------------------------------------

public class SelectionSort {

    static void selection(int[] arr) {
        // Minimum element
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
        int[] arr = { 4, 1, 5, 2, 3 };
        selection(arr);
        print(arr);
    }

}
