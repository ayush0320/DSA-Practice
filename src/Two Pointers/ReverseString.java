public class ReverseString {

    // public static String reverseString(String s) {
    // int left = 0;
    // int right = s.length() - 1;
    // char[] charArr = s.toCharArray(); // Convert the string to a character array
    // to allow modification

    // while (left < right) {
    // char temp = charArr[left];
    // charArr[left] = charArr[right];
    // charArr[right] = temp;

    // left++;
    // right--;
    // }

    // return new String(charArr); // Convert the character array back to a string
    // and return it
    // }

    // ----------------------------------------------------------------------

    // Input is a character array, so we can modify it in place and return void
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // String s = "HELLO";
        char[] s = { 'H', 'E', 'L', 'L', 'O' };
        reverseString(s);
        System.out.println(s);
    }

    // static - so that we can call the method without creating an instance of the
    // class
    // static methods can be called directly using the class name, which is useful
    // for utility methods like this one that don't rely on instance variables
}
