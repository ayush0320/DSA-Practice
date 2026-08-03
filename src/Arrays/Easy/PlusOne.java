// LC 66. Plus One
// https://leetcode.com/problems/plus-one/

// for (go from last index to first) {

// if (current digit < 9) {
// increase it
// return answer immediately
// }

// otherwise digit was 9
// make it 0 and continue
// }

// if you reach here,
// every digit was 9

// create new array of size n+1
// put 1 at the front

//-------------------------------------------------------------------------------

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
                continue;
            }
        }
        int[] newArr = new int[n + 1];
        newArr[0] = 1;
        return newArr;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };
        int[] result = plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}
