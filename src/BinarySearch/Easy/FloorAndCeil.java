// Floor and Ceil of a target in a sorted array
// Floor - largest element <= target (closest smaller element)
// Ceil - smallest element >= target (closest greater element)
// x = 25
// arr = [10, 20, 30, 40, 50]
// floor = 20
// ceil = 30

public class FloorAndCeil {

    static int floor(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid]; // potential answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------

    static int ceil(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid]; // potential answer
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 25;
        System.out.println("Floor: " + floor(arr, target));
        System.out.println("Ceil: " + ceil(arr, target));
    }
}
