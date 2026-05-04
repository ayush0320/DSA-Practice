// Easy
// A number is a power of 2 if (and only if) it’s greater than zero 
// and has exactly 1 bit set in its binary representation.
// For example:
// 1 (2⁰) = 0001
// 2 (2¹) = 0010
// 4 (2²) = 0100
// 8 (2³) = 1000

public class PowerOf2 {

    public static boolean isPowerOf2(int num) {

        while (num > 1) {
            if (num % 2 != 0) {
                return false;
            } else {
                num = num / 2;
            }
        }
        return num == 1;

        // if (num <= 0)
        // return false;
        // return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPowerOf2(num));
    }
}
