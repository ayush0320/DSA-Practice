// GFG - https://www.geeksforgeeks.org/dsa/next-permutation/
// LEETCODE - https://leetcode.com/problems/next-permutation/description/
// Tutorial - https://youtu.be/JDOXKqF60RQ
// Lexicographic array manipulationv

// =========================

package arrays.hashing;

public class NextPermutation {

    // BRUTE FORCE APPROACH
    // 1. Generate all permutations
    // 2. Linear search
    // 3. Next index
    // TC - O(n! * n) - very large
    // SC - O(n! * n) - very large

    // -------------------------

    // OPTIMAL APPROACH
    // 1. Longer prefix match
    // break point - a[i] < a[i+1]
    // 2. find smallest integer (closest) > a[i]
    // 3. Place remaining in sorted (ascending) order

    static void nextPerm(int[] arr) {
        int n = arr.length;

        // 1. Find break point
        int point = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                point = i;
                break;
            }
        }

        // 2. Find element from the right just greater than break point
        for (int i = n - 1; i >= point; i--) {
            if (arr[i] > arr[point]) {
                swap(arr, point, i);
                break;
            }
        }

        // If break point does not exist
        if (point == -1) {
            reverse(arr, 0, -1);
            return;
        }

        // 3. Reverse the remaining
        reverse(arr, point + 1, n - 1);
    }

    // Function to reverse the array - edge case - last possible permutation
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    // Swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // -------------------------

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 7, 5, 0 };
        nextPerm(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
