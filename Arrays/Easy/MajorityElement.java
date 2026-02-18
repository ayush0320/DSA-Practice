import java.util.HashMap;
import java.util.Map;

// Pattern -> 
// HashMap / HashSet / Frequency counting
// Use when: Find duplicates / Count elements / Fast lookup

// https://leetcode.com/problems/majority-element/
// Pattern -> Boyer-Moore Voting Algorithm

public class MajorityElement {

    // 1. Brute Force Approach
    // Two nested loops to count the frequency of each element and find the majority
    // element
    // Time Complexity: O(n^2) - because we are counting the frequency of each
    // element in the array
    // Space Complexity: O(1) - we are using only a constant amount of space

    // ------------

    // static int majority(int[] nums) {
    // int count = 0;
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // count = 0; // reset count for each element
    // for (int j = 0; j < n; j++) {
    // if (nums[i] == nums[j]) {
    // count++;
    // }
    // }
    // if (count > n / 2) {
    // return nums[i];
    // }

    // }
    // return -1;

    // _______________________________________________________________________

    // 2. Better Approach
    // Using HashMap to count the frequency of each element and find the majority
    // map.getOrDefault(num, 0) returns the current count of num in the map, or 0 if
    // num is not present in the map. We then add 1 to this count and put it back in
    // the map with num as the key.
    // Time Complexity: O(n) - we are iterating through the array once to count the
    // frequency of each element
    // Space Complexity: O(n) - in the worst case, all elements are different and we
    // store them in the map

    // ------------

    // static int majority(int[] nums) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // int n = nums.length;
    // for (int num : nums) {

    // map.put(num, map.getOrDefault(num, 0) + 1);
    // if (map.get(num) > n / 2) {
    // return num;
    // }
    // }
    // return -1;
    // }

    // _______________________________________________________________________

    // Optimal Approach
    // Boyer-Moore Voting Algorithm
    // Majority element appears more than all other elements combined.
    // If we cancel one majority element with one non-majority element, the majority
    // element will still remain.
    // 1. Initialize two variables: candidate and count.
    // 2. Traverse array:
    // - If count == 0:
    // - set candidate = current number
    // - If current number == candidate:
    // - count++
    // - Else:
    // - count--
    // 3. After the loop, candidate will hold the majority element.
    // Time Complexity: O(n) - we are iterating through the array once
    // Space Complexity: O(1) - we are using only a constant amount of space

    // ------------

    static int majority(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 2, 2 };
        System.out.println(majority(nums));
    }
}
