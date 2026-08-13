// Lc 268. Missing Number

// https://leetcode.com/problems/missing-number/description/

// ----------------------------------------------------------------------
package arrays.hashing;

import java.util.HashSet;

public class MissingElement {

    // BRUTE FORCE APPROACH
    // TC = O(n^2)
    // SC = O(1)

    public static int missingNumber(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }
        }

        return -1;
    }

    // =================================================

    // BETTER APPROACH
    // TC = O(n)
    // SC = O(n)

    public static int missingNumber2(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            return i;
        }

        return -1;

    }

    // =================================================

    // OPTIMAL APPROACH
    // Sum Formula = n(n+1)/2
    // TC = O(n)
    // SC = O(1)
    public static int missingNumber3(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 0, 4, 3 };
        int missing = missingNumber3(arr);
        System.out.println(missing);
    }
}
