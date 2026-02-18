import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// Sliding Window (Basic)
// Signals: Continuous subarray/substring
// Longest/shortest length

// Key signals:
// ✅ contiguous subarray
// ✅ variable size window
// ✅ maximize/minimize

public class LongestSubstringWithoutRepeatingCharacters {

    // Brute Force Approach
    // We use two nested loops to generate all possible substrings of the input
    // string. For each substring, we check if it contains all unique characters by
    // adding the characters to a HashSet. If we encounter a duplicate character, we
    // break out of the inner loop. If the substring is valid (i.e., it contains all
    // unique characters), we compare its length with the maximum length found so
    // far and update the maximum length if necessary. Finally, we return the
    // maximum length found. These nested loops result in a time complexity of
    // O(n^3) in the worst case, where n is the length of the input string. The
    // space complexity is O(min(m, n)) where m is the size of the character set and
    // n is the length of the string, since in the worst case, we may have to store
    // all characters in the current substring.

    // ------------------------------------------------------------------------

    // Optimal Approach (Sliding Window)
    // Using a HashSet to store the characters in the current window
    // O(1) for:
    // ✅ Fast lookup
    // ✅ Fast insert
    // ✅ Fast delete

    // Two pointers, left and right, that define the current window.
    // Iterate through the string with the right pointer -> add characters to the
    // set.
    // If encounter a character that is already in the set -> repeating character.
    // Remove characters from the left side (moving the left pointer) until we
    // remove the duplicate character
    // After processing each character with the right pointer, we
    // calculate the length of the current window (right - left + 1)
    // and update our maximum length if necessary.
    // Finally, we return the maximum length found.
    // Time complexity: O(n) because each character is visited at most twice (once
    // by the right pointer and once by the left pointer).
    // Space complexity: O(min(m, n)) where m is the size of the character set and n
    // is the length of
    // the string, since in the worst case, we may have to store all characters in
    // the current window.

    static int lengthOfSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right + 1 - left);
        }
        return maxLength;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfSubstring(s);
        System.out.println(result);
    }
}
