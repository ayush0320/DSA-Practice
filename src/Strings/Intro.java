// String is a class in Java, so we can create String objects
// DataType refVariableName = objectValue;
// String pool - a special memory area where String literals are stored.
// String pool allows for memory optimization by reusing String literals.
// When a String literal is created, Java checks the pool to see if an identical String already exists.
// If it does, the new reference points to the existing String.
// If not, a new String is created in the pool.
// Strings are immutable. For security and performance reasons.
// Any operation that seems to modify a String actually creates a new String object.

public class Intro {

    public static void main(String[] args) {

        // String a = "Ethan"; // String literal, stored in the String pool
        // System.out.println(a);
        // a = "Hunt"; // a now references a new String object "Hunt", "Ethan" is still
        // in the pool but not referenced by 'a'
        // System.out.println(a);

        // ----------------------------------------------------------------------

        // Comparing Strings
        String a = "123";
        String b = "123";
        System.out.println(a == b); // true, both a and b reference the same String literal in the pool

        String c = new String("123"); // creates a new String object in the heap
        System.out.println(a == c); // false, a references the String literal in the pool
        System.out.println(a.equals(c)); // true, equals() checks the content of the strings

        // ----------------------------------------------------------------------

        // Syste.out.println() converts the argument to a String using the toString()
        // method of the object

    }
}