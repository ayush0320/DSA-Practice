// LC 278. First Bad Version

// Minimum number of calls to isBadVersion API to find the first bad version
// Solve this problem on LeetCode: https://leetcode.com/problems/first-bad-version/
// https://www.youtube.com/watch?v=86SBizUsbGY

// BOUNDARY CONDIION:
// while(left <= right) - X
// while(left < right) - ✓
// We do not seach for the actual index, insead we are looking for boundary between valid/invalid

// [good, good, good, bad, bad, bad]
//                ↑
//          first bad version

// Example problesms that follow this pattern:
// Koko eating bananas
// First bad version
// Minimum capacity problems

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
