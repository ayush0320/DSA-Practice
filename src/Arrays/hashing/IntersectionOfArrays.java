// LC 349. Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/

// ----------------------------------------------------------------------
package arrays.hashing;

import java.util.HashSet;

public class IntersectionOfArrays {

    // Time: O(n + m)
    // Build first set: O(n)
    // Traverse second array: O(m)
    // Space: O(n) HashSet stores elements of nums1

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        // store all the elements of num1 in HashSet
        // HashSet ignores duplicates
        for (int num : nums1) {
            set.add(num);
        }

        // store unique intersection
        HashSet<Integer> result = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        // convert HashSet to int[]
        int[] ans = new int[result.size()];
        int index = 0;

        for (int num : result) {
            ans[index++] = num;
            // index = index + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        int[] common = intersection(nums1, nums2);
        for (int num : common) {
            System.out.println(num);
        }

    }
}
