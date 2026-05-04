// This class demonstrates the concept of skipping characters in a string using recursion.
// https://www.youtube.com/watch?v=gdifkIwCJyg&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=7

// Base Case:   
// • isEmpty() is a method in the String class that checks if the string is empty
//   (i.e., has a length of 0). 
// • If unprocessed.isEmpty() returns true, it means
//   there are no more characters left to process, and we can print the processed
//   string and exit the function.

// • Processed - string that has been built up so far with the characters that have been processed.
// • Unprocessed - string that still needs to be processed, which initially contains the
//   entire input string and gets reduced as characters are processed.

// • substring(1): method in the String class that returns a new string 
//   that is a substring of the original string, 
//   starting from index 1 (the second character) to the end of the string. 
// • This effectively removes the first character of the unprocessed string, 
//   allowing us to continue processing the remaining characters in 
//   the next recursive call.

// ------------------------------------------------------------------------

public class SkiAChar {

    static void skip(String processed, String unprocessed) {

        // Base case: If the unprocessed string is empty, print the processed string and
        // return.
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0); // first character of the unprocessed string

        if (ch == 'a') {
            skip(processed, unprocessed.substring(1));
        } else {
            // Recursive call with the first character added to processed and the rest of
            // the unprocessed string
            skip(processed + ch, unprocessed.substring(1));
        }
    }

    // ------------------------------------------------------------------------

    // Return a string after skipping all occurrences of 'a' in the input string.
    static String skip2(String unprocessed) {

        // Base case: If the unprocessed string is empty return an empty string.
        if (unprocessed.isEmpty()) {
            return "";
        }

        char ch = unprocessed.charAt(0); // first character of the unprocessed string

        if (ch == 'a') {
            // Recursive call without adding the first character to the result
            return skip2(unprocessed.substring(1));
        } else {
            // Recursive call with the first character added to the result of the recursive
            // call
            return ch + skip2(unprocessed.substring(1));
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        skip("", "baccad");
        System.out.println(skip2("baccad"));

    }
}
