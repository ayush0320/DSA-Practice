// String Builder is a mutable sequence of characters, unlike String which is immutable.
// StringBuilder is more efficient for concatenating strings in a loop or when performing multiple modifications to a string
// It does not create a new object each time like String does.
// Used when you need to modify a string frequently, such as in loops or when building a string from multiple parts.
// Optimizes memory usage and performance by avoiding the creation of multiple String objects.

public class Builder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i); // 'a' is 97 in ASCII, so this will generate characters from 'a' to 'z'
            sb.append(ch); // append the character to the StringBuilder
        }
        System.out.println(sb.toString()); // convert StringBuilder to String and print it
    }
}
