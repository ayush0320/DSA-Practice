// Sort an array of 0s, 1s and 2s - Dutch National Flag Problem
// https://www.geeksforgeeks.org/dsa/sort-an-array-of-0s-1s-and-2s/

// ========================================================================

package arrays.medium;

import java.util.Arrays;

public class DutchNationalFlag {

    // BRUTE FORCE APPROACH
    // Sort using library function or use any sorting algorithm
    // TC = O(n)
    // SC = O(1)

    static void sort012(int[] arr) {
        Arrays.sort(arr);
    }

    // ------------------------------------------------------------------------

    // DUTCH NATIONAL FLAG ALGORITHM - ONE PASS
    // TC = O(n)
    // SC = O(1)

    // three pointers:
    // low — everything before low is confirmed 0
    // mid — the current element you're examining
    // high — everything after high is confirmed 2

    // The unexamined/unknown region is always between mid and high. You march mid
    // through the array and make a decision based on arr[mid]:
    // If arr[mid] == 0 → it belongs in the "0 zone." Swap arr[mid] with arr[low],
    // then move both low++ and mid++
    // If arr[mid] == 1 → it's already in the right place. Just move mid++
    // If arr[mid] == 2 → it belongs in the "2 zone." Swap arr[mid] with arr[high],
    // then move high-- — but do NOT move mid yet

    static void dutchAlgorithm(int[] arr) {
        int n = arr.length;

        // low - boundary of 0
        // mid - value being tracked
        // high - boundary of 2
        // initially both low and mid start from the front
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                // swap with low and move both pointers forward
                int temp = arr[low];
                arr[low++] = arr[mid];
                arr[mid++] = temp;
            } else if (arr[mid] == 1) {
                // mid at correct place, just move it forward
                mid++;
            } else {
                // mid == 2, swap with high
                // move high backward
                int temp = arr[high];
                arr[high--] = arr[mid];
                arr[mid] = temp;
            }
        }

    }

    // static void swap(int a, int b) {
    // int temp = a;
    // a = b;
    // b = temp;
    // }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2 };
        // sort012(arr);
        dutchAlgorithm(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
