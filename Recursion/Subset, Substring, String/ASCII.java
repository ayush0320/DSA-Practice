// char ch = 'a';
// System.out.println((int) ch) prints the ASCII value of 'a', which is 97
// automatically converts char to int when we try to print it as an integer
// System.out.println(ch + 0);

public class ASCII {

    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
        subseq(p + (ch + 0), up.substring(1)); // include the ASCII value of the character

    }

    public static void main(String[] args) {
        subseq("", "abc");
    }
}
