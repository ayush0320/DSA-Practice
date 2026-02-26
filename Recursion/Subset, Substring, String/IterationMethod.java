// Subset, Substring, String
// Find subsets of a string using iteration method
// https://www.youtube.com/watch?v=gdifkIwCJyg&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=8

// • List - a collection of elements that can grow and shrink dynamically
// • ArrayList - a resizable array implementation of the List interface in Java
// • We can use an ArrayList to store the subsets of a string because it 
//   allows us to easily add new subsets as we generate them

import java.util.List;

public class IterationMethod {

    static List<List<Integer>> subsets(int[] arr) {
        // create an outer list to store all the subsets
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>()); // add an empty subset

        return outer;
    }

    public static void main(String[] args) {

    }
}
