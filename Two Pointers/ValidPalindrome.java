public class ValidPalindrome {

    // public static boolean isPalindrome(String s) {
    // int left = 0;
    // int right = s.length() - 1;

    // while (left < right) {
    // // skip non-alphanumeric characters from the left
    // while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
    // left++;
    // }
    // // skip non-alphanumeric characters from the right
    // while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
    // right--;
    // }

    // // compare characters in a case-insensitive manner
    // char leftCh = Character.toLowerCase(s.charAt(left));
    // char rightCh = Character.toLowerCase(s.charAt(right));

    // if (leftCh != rightCh) {
    // return false;
    // }
    // left++;
    // right--;
    // }
    // return true;
    // }

    // ----------------------------------------------------------------------

    // Replacement Approach
    // Regex to remove non-alphanumeric characters and then compare characters in a
    // case-insensitive manner
    // ^ means negation, so [^a-zA-Z0-9] matches any character that is NOT a letter
    // or digit, and replaceAll will replace those characters with an empty string,
    // effectively removing them from the string.
    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
