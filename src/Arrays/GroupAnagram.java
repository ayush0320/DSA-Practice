import java.util.*;

// Medium
// Group Anagram problem using HashMap
// Categorize strings by frequency of characters
public class GroupAnagram {

    public static List<List<String>> groupedAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>(); // Return empty list if input is null or empty
        }

        // HashMap to group anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {

        }
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupedAnagrams(strs));
    }
}
