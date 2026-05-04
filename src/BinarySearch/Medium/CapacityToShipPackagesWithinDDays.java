// LC 1011. Capacity To Ship Packages Within D Days
// https://www.youtube.com/watch?v=MG-Ac4TAvTY
// CONCEPT - BINARY SEARCH ON THE ANSWER SPACE
// We can apply BS on unsorted array by eliminating the search space based on the feasibility of the solution.
// Pattern Signals:
// minimize / maximize
// smallest possible
// feasible solution

// weights[]  → weights of packages (in order)
// days       → number of days available
// Q: We need to find the minimum capacity of the ship such that we can ship all the packages within the given number of days.

// Binary Search Approach:
// - The capacity of the ship has to be at least the maximum weight in the weights array, 
//   because we cannot split a package and we have to ship all packages in order. 
// - The maximum capacity of the ship can be the sum of all weights, 
//   because we can ship all packages in one day if the ship has enough capacity.

// - Answer Space: maximum weight in array <= capacity of ship <= totalweights
// - Apply BS on answer space (capacity of the ship)

// Helper Function:
// load = 0
// add 3 → load = 3
// add 2 → load = 5
// add 2 → would be 7 > 6 → new day

// Time Complexity - O(log(sum(weights)) * n) 
// - where n is the number of packages 
// - and log(sum(weights)) is the number of iterations in the binary search.

public class CapacityToShipPackagesWithinDDays {

    // Binary Search Approach

    public int shipWithinDays(int[] weights, int days) {
        int left = 0;// initialize left to 0, we will update it to max weight in the array
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight); // minimum weight of a package
            right += weight; // total weight of all packages
        }

        while (left < right) {
            int capacity = left + (right - left) / 2;

            if (canShip(weights, days, capacity)) {
                right = capacity; // try smaller capacity
            } else {
                left = capacity + 1; // try larger capacity
            }
        }
        return left; // or right, both are same at the end of the loop
    }

    // Helper function to check if we can ship all packages within the given number
    // of days with the given capacity
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0;
        int daysNeeded = 1; // we start with day 1
        for (int weight : weights) {
            if (currentLoad + weight <= capacity) {
                currentLoad += weight; // load the package onto the current day
            } else {
                daysNeeded++;
                currentLoad = weight; // start loading the next day with the current package
            }
        }
        return daysNeeded <= days; // check if we can ship within the given number of days
    }

    // ------------------------------------------------------------------------

    // Optimized Approach - using helper function to calculate days needed for a
    // given capacity

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        CapacityToShipPackagesWithinDDays solution = new CapacityToShipPackagesWithinDDays();
        int result = solution.shipWithinDays(weights, days);
        System.out.println(result);
    }

}
