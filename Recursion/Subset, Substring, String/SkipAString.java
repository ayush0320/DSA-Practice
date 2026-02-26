// Skip a string in a string
// • Given a string, skip all occurrences of the substring "apple" and return the resulting string
// • startsWith() method is used to check if the unprocessed string starts with the substring "apple".
// • If it does, we make a recursive call to skipApple() with the unprocessed

public class SkipAString {

    static String skipApple(String unprocessed) {
        // Base case
        if (unprocessed.isEmpty()) {
            return "";
        }

        // Check if the unprocessed string starts with "apple"
        if (unprocessed.startsWith("apple")) {
            return skipApple(unprocessed.substring(5));
        } else {
            // first character added to the result of the recursive call
            return unprocessed.charAt(0) + skipApple(unprocessed.substring(1));
        }

    }

    public static void main(String[] args) {
        System.out.println(skipApple("pineapple"));
    }
}
