// Subset of a string
// https://www.youtube.com/watch?v=gdifkIwCJyg&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=7
// • Subsets of the string "abc" are: "", "a", "b", "c", "ab", "ac", "bc", and "abc".
// • Non-adjacent collection of characters from the string.
// • Order is conserved.
// • Subsequence:
//   1.Subsets - arrays
//   2.Substring - strings

// • Pattern: 
//   1. Taking or removing some elements
//   2. Permutations & Combinations

// • Processed String (p): the subset formed so far
// • Unprocessed String (up): original string passed as parameter
//   one of the subsets is found when up is empty
// • Two choices for every character: include it in the subset or exclude it

// • p and up create new strings in every recursive call, so we don't need to backtrack
// • because strings are immutable in Java, we can create new strings
//   without worrying about modifying the original string

// Time Complexity: O(2^n) - because each character has two choices (include or exclude)
// Space Complexity: O(n) - due to the recursive call stack, where n is the length of the input string

import java.util.ArrayList;

public class Subsets {

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0); // get the first character

        // include the first character in the subset
        subseq(p + ch, up.substring(1));

        // exclude the first character from the subset
        subseq(p, up.substring(1));

    }

    // ------------------------------------------------------------------------

    // ArrayList version
    static ArrayList<String> subseq2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0); // get the first character

        // include the first character in the subset
        ArrayList<String> left = subseq2(p + ch, up.substring(1));

        // exclude the first character from the subset
        ArrayList<String> right = subseq2(p, up.substring(1));

        // combine the results from both choices
        // left will contain subsets that include the character,
        // right will contain subsets that exclude the character
        left.addAll(right);
        return left;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        String sequence = "abc";
        System.out.println(subseq2("", sequence));
    }
}
