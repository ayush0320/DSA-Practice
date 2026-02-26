// https://www.youtube.com/watch?v=sTdiMLom00U&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=3

public class SortedArray {

    static boolean isSorted(int[] arr, int index) {
        // base case
        if (index == arr.length - 1) {
            return true; // last element is always sorted
        }

        // recursive case
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(isSorted(arr, 0));
    }
}
