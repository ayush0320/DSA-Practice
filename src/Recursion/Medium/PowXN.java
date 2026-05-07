package recursion.medium;
// LC 50. Pow(x, n)
// https://www.youtube.com/watch?v=l0YC3876qxg
// Given a double x and an integer n, return the result of x raised to the power n (i.e., x^n).
// n can be negative, zero, or positive.
// Concepts:
// 1. Base case
// 2. Recursive call
// 3. Stack frames

// • double: represent decimal numbers, including very large and very small values.
// • long: integer values that can be larger than what int can hold, 
//   useful for handling the absolute value of n when n is negative and can potentially cause overflow.

public class PowXN {

    // Brute Force Approach
    // • Loop from 1 to n and multiply x to the result in each iteration.
    // • Time complexity: O(n) - we perform n multiplications.
    // • Space complexity: O(1) - we use a constant amount of space for the result
    // variable.
    // • Since value of n can be negative, we can take the absolute value of n and
    // compute the power as if n were positive.
    // • The value of int can be as low as -2^31, and taking the absolute value of
    // -2^31 would cause an overflow. To handle this, we can use a long variable to
    // store the absolute value of n, which can accommodate the range of values
    // without overflow.

    static double myPow(double x, int n) {
        long power = n; // convert to long to handle the case when n is Integer.MIN_VALUE

        if (power < 0) {
            x = 1 / x; // if n is negative, we take the reciprocal of x
            power = -power; // and convert n to positive
        }

        double result = 1.0;

        for (long i = 0; i < power; i++) {
            result *= x; // multiply x to the result in each iteration
        }

        return result;
    }

    // ------------------------------------------------------------------------

    // Optimal Approach
    // • Binary Exponentiation (also known as Exponentiation by Squaring)
    // • n is even
    // x^n = (x^(n/2))^2
    // • n is odd
    // x^n = x * x^(n-1)
    // • Example: x = 2, n = 10
    // 2^10 = (2^2)^5
    // 2^5 = 2 * 2^4
    // 2^4 = (2^2)^2
    // • power & 1 checks if the power is odd (if the least significant bit is 1)
    // • power >>= 1 is equivalent to power = power / 2, but it's more efficient for
    // integer division by 2.

    static double myPow2(double x, int n) {
        long power = n;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            if ((power & 1) == 1) { // if power is odd
                result *= x; // multiply x to the result
                power -= 1; // subtract 1 from power to make it even
            } else { // if power is even
                x *= x;
                power >>= 1; // divide power by 2
            }
        }
        return result;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println(myPow2(2.00000, 10));
    }
}
