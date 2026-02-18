import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // Function to generate pascal's triangle upto n rows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(); // This will hold the rows of Pascal's Triangle

        if (numRows <= 0) {
            return triangle; // Return empty triangle for non-positive input
        }

        List<Integer> firstRow = new ArrayList<>(); // Create the first row
        firstRow.add(1);
        triangle.add(firstRow); // Add the first row [1]

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>(); // New row to be added

            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j)); // Each element is sum of two above it
            }

            row.add(1); // Last element is always 1
            triangle.add(row); // Add the constructed row to the triangle
        }

        return triangle;
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle(); // Create an object of PascalsTriangle
        List<List<Integer>> result = obj.generate(1); // Generate Pascal's Triangle with 5 rows
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}

// a) What is List<>?
// List is a list interface in Java. Like a container that can hold
// multiple items in a row, like a to-do list.
// The <Integer> part means this List will hold numbers (integers).
// List<List<Integer>> means a list of lists of integers. So, it's like a table,
// or a grid, or a list where each item is also a list—a 2D structure.

// b) result = obj.generate(n);
// obj.generate(n) is calling a function named generate on an object named obj.
// The argument n is likely just a number (like 5).
// This method probably returns Pascal's Triangle as a 2D list.
// The result (the 2D list) is stored in a variable named result