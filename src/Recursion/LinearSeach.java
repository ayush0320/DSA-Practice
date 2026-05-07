package recursion;
import java.util.ArrayList;

// Time Complexity: O(n) where n is the number of elements in the array
// Space Complexity: O(n) in the worst case when all elements are the target, otherwise O(1) for the linear search

public class LinearSeach {

    static int linearSearch(int[] arr, int target, int index) {
        // base case
        if (arr.length == 0 || index >= arr.length) {
            return -1; // not found
        }

        // recursive case
        if (arr[index] == target) {
            return index; // found at index 0
        } else {
            return linearSearch(arr, target, index + 1);
        }
    }

    // ------------------------------------------------------------------------

    // Find all the indices of the target in the array
    // Return an ArrayList of indices where the target is found
    // Time Complexity: O(n) where n is the number of elements in the array

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index,
            ArrayList<Integer> list) {
        if (index >= arr.length) {
            return list; // not found
        }

        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }

    // ------------------------------------------------------------------------

    // Return the list but without passing it as an argument
    // Return type will be ArrayList<Integer> instead of void
    // PROBLEM: we are creating a new list in every recursive call which is not
    // efficient
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if (index >= arr.length) {
            return list; // not found
        }
        if (arr[index] == target) {
            list.add(index);
        }

        // get the list from the below calls and add it to the current list
        ArrayList<Integer> listFromBelowCalls = findAllIndex2(arr, target, index + 1);
        list.addAll(listFromBelowCalls);
        return list;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 4, 5 };
        int target = 2;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));

    }
}
