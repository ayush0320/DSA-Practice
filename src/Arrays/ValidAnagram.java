// Bucket array implementation for Valid Anagram problem
// Easy

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        // Convert both strings to lowercase to ensure case insensitivity
        String string1 = s.toLowerCase();
        String string2 = t.toLowerCase();

        // Remove whitespace from both strings
        string1 = string1.replace(" ", "");
        string2 = string2.replace(" ", "");

        if (string1.length() != string2.length()) {
            return false;
        }

        // Create a bucket array to count character frequencies
        int[] buckets = new int[26];

        // Populate the bucket array based on characters in both strings
        for (int i = 0; i < string1.length(); i++) {
            buckets[string1.charAt(i) - 'a']++;
        }

        // Decrease the count based on characters in the second string
        for (int i = 0; i < string2.length(); i++) {
            buckets[string2.charAt(i) - 'a']--;
        }

        // Check if all counts in the bucket array are zero
        for (int bucket : buckets) {
            if (bucket != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("rat", "car"));
    }

}
