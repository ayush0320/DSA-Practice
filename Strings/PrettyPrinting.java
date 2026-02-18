public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 3.14159f;
        // System.out.println(a); // 3.14159
        System.out.printf("Formatted string: %.2f", a); // 3.14, %.2f means format the float to 2 decimal places

        // System.out.printf("%10.2f", a); // " 3.14", 10 means the total width of the
        // output, including the decimal point and digits, is 10 characters,
        // right-aligned by default

        // System.out.printf("%-10.2f", a); // "3.14 ", left-aligned within a 10
        // character width

        // ----------------------------------------------------------------------

        // Placeholders
        // %s for String, %d for integer, the arguments are substituted in order
        System.out.printf("Hello my name is %s and I am %d years old", "Ethan", 30);
    }
}
