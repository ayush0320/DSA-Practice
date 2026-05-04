// Easy

public class PowerOf3 {

    public static boolean isPowerOf3(int n) {
        if (n <= 0)
            return false;
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            } else {
                n = n / 3;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOf3(n));
    }
}
