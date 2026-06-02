// 88. Merge Sorted Array
// https://youtu.be/0H6038ldSyg
// Given arrays nums1 and nums2 sorted in non-decreasing order
// Can't create new array
// Two pointer

// ----------------------------------------------------------------------------------

package arrays.easy;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // last element of nums1
        int j = n - 1; // last element of nums2
        int k = m + n - 1; // last element of merged array

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println("Merged array: ");
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

}
