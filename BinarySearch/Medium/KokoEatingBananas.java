// LC875 - Koko Eating Bananas
// https://www.youtube.com/watch?v=qyfekrNni90
// https://www.youtube.com/watch?v=U2SozAs9RzA
// CONCEPT - BINARY SEARCH ON THE ANSWER SPACE
// We can apply BS on unsorted array by eliminating the search space based on the feasibility of the solution.
// Pattern Signals:
// minimize / maximize
// smallest possible
// feasible solution

// piles[] - array of piles of bananas
// h - hours before the guards return
// h will always be >= no of piles, meaning Koko can eat at least 1 banana per hour, so minimum k = 1
// k - eating speed (bananas per hour)
// We need to find the minimum k such that Koko can eat all the bananas in h hours.
// We are not searching inside the array, meaning - BS on possible answers
// If Koko eats at speed equal to biggest pile → finishes each pile in 1 hour.
// Round off - if Koko eats at speed k, and there are p bananas in a pile, then it will take ceil(p/k) hours to finish that pile.

public class KokoEatingBananas {

    // Brute Force Approach
    // k will always be between 1 and max[piles] (Array.MAX_VALUE),
    // Ex - piles = [3, 6, 7, 11], h = 8
    // k can be between 1 and 11, so we can iterate through all possible values of k
    // Answer space: k = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] bananas per hour
    // k != 0 because Koko has to eat at least 1 banana per hour
    // max(piles) is the maximum number of bananas in any pile
    // Times Complexity - O(max(piles) * n) - where n is the number of piles and

    // ------------------------------------------------------------------------

    // Binary Search Approach
    // Instead of iterating through all possible values of k, we can use BS to find
    // the minimum k.

    // To calculate the hours needed to eat all the bananas at speed k, we can use
    // the formula:
    // hours = sum(ceil(pile / k)) for each pile in piles
    // hours += pile / k;
    // if (pile % k != 0) {
    // hours++;
    // }
    // is same as: ceil(a / b) == (a + b - 1) / b

    // Time Complexity - O(log(max(piles)) * n) - where n is the number of piles and
    // log(max(piles)) is the number of iterations in the binary search.

    // Space Complexity - O(1) - we are not using any extra space

    // ------------------------------------------------------------------------

    // static int minEatingSpeed(int[] piles, int h) {
    // int left = 1; // minimum eating speed
    // int right = 0; // maximum eating speed

    // // Finding the maximum eating speed, which is the size of the largest pile
    // for (int pile : piles) {
    // right = Math.max(pile, right);
    // }

    // while (left < right) {
    // int k = left + (right - left) / 2; // eating speed

    // // Calculate the total hours needed to eat all the bananas at speed mid
    // int hours = 0;
    // for (int pile : piles) {
    // hours += (pile + k - 1) / k; // equivalent to ceil(pile / k)
    // }

    // if (hours <= h) {
    // right = k; // search in the left half to find a smaller eating speed
    // } else {
    // left = k + 1;
    // }
    // }

    // return left; // or right, both are the same at the end of the loop
    // }

    // ------------------------------------------------------------------------

    // Optimized Approach - using helper function to calculate hours needed for a
    // given eating speed k
    // Time Complexity - O(log(max(piles)) * n) - where n is the number of piles and
    // log(max(piles)) is the number of iterations in the binary search.
    // Space Complexity - O(1) - we are not using any extra space

    static int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum eating speed
        int right = 0; // maximum eating speed

        // Finding the maximum eating speed, which is the size of the largest pile
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int k = left + (right - left) / 2; // eating speed

            // Calculate the total hours needed to eat all the bananas at speed mid
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + k - 1) / k; // equivalent to ceil(pile / k)
            }

            if (hours <= h) {
                right = k; // search in the left half to find a smaller eating speed
            } else {
                left = k + 1;
            }
        }

        return left; // or right, both are the same at the end of the loop
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
