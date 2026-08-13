// LC 2149 - https://leetcode.com/problems/rearrange-array-elements-by-sign/
// GFG - https://www.geeksforgeeks.org/dsa/rearrange-array-alternating-positive-negative-items-o1-extra-space/
// Two-pointer rearrangement 

// =========================

package arrays.medium;

import java.util.ArrayList;

public class RearrangeArrayBySign {

    // BRUTE FORCE APPROACH
    static ArrayList<Integer> rearrange(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        // Split into positives and negatives (preserves relative order)
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int posIdx = 0;
        int negIdx = 0;
        int i = 0;

        // Interleave while BOTH lists still have elements
        while (posIdx < pos.size() && negIdx < neg.size()) {
            if (i % 2 == 0) {
                ans.add(pos.get(posIdx++));
            } else {
                ans.add(neg.get(negIdx++));
            }
            i++;
        }

        // Leftovers
        while (posIdx < pos.size()) {
            ans.add(pos.get(posIdx++));
        }
        while (negIdx < neg.size()) {
            ans.add(neg.get(negIdx++));
        }

        return ans;
    }

    // -------------------------

    // OPTIMAL APPROACH
    // Without using extra ArrayList
    // Same number of positive and negative integers
    static int[] rearrangeII(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        int posIdx = 0;
        int negIdx = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                arr[negIdx] = arr[i];
                negIdx += 2;
            } else {
                ans[posIdx] = arr[i];
                posIdx += 2;
            }
        }

        return ans;

    }

    // -------------------------

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, -2, -5 };
        // ArrayList<Integer> ans = rearrange(arr);
        int[] ans = rearrangeII(arr);
        // System.out.println(ans); // [3, -2, 1, -5, 4]

        for (int num : ans) {
            System.out.println(num);
        }
    }
}
