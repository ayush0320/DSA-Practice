// GFG - https://www.geeksforgeeks.org/problems/frequency-of-elements--111353/1

// HAshMap Counting

// ===========================================================
package arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfArrayElements {

    // BRUTE FORCE APPROACH
    // TC - O(n^2)
    // SC - O(n)
    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (visited[i])
                continue;

            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j])
                    visited[j] = true;
                count++;
            }

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr[i]);
            temp.add(count);
            ans.add(temp);
        }

        return ans;
    }

    // ----------------------------------------------------------------

    // BETTER APPROACH - HASHMAP
    // getOrDefault(Object key, V defaultValue) - returns the value mapped to the
    // specified key, or the provided fallback defaultValue if the map
    // contains no mapping for that key

    // A HashMap internally stores data as key-value pairs
    // entrySet() converts the whole map into a Set of Map.Entry objects
    // So for a map {1=1, 2=2, 3=2, 5=1}, entrySet() gives you something
    // conceptually like:
    // { (1,1), (2,2), (3,2), (5,1) }

    public static ArrayList<ArrayList<Integer>> countFreq2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // count frequency using hashmap
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(entry.getKey()); // add the element
            temp.add(entry.getValue()); // add the value
            ans.add(temp); // add both bundeled together in the ans list

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 5, 20 };
        ArrayList<ArrayList<Integer>> ans = countFreq2(arr);
        System.out.println(ans);
    }
}
