// LC 278. First Bad Version
// [good, good, good, bad, bad, bad]
//                ↑
//          first bad version
// Minimum number of calls to isBadVersion API to find the first bad version
// Solve this problem on LeetCode: https://leetcode.com/problems/first-bad-version/
// https://www.youtube.com/watch?v=86SBizUsbGY

// ------------------------------------------------------------------------

public class FirstBadVersion {

    // This is a mock implementation of the isBadVersion API for testing purposes.
    // public class Solution extends VersionControl {

    // public int firstBadVersion(int n) {

    // int left = 1;
    // int right = n;

    // while (left < right) {

    // int mid = left + (right - left) / 2;

    // if (isBadVersion(mid)) {
    // // mid could be the first bad version
    // right = mid;
    // } else {
    // // first bad must be after mid
    // left = mid + 1;
    // }
    // }

    // return left; // or right (both same here)
    // }
    // }

    public static void main(String[] args) {
        // int n = 5;
        // System.out.println(firstBadVersion(n));

    }
}
