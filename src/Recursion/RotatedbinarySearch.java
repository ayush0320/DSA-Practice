// Q: Search in a rotated sorted array
// arr[] = {4, 5, 6, 7, 0, 1, 2} target = 0

public class RotatedbinarySearch {

    // Binary Search
    // Time Complexity: O(log n) - Binary Search
    // Space Complexity: O(1) - Constant space

    static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        if (arr.length == 0) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                // left half is sorted
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half is sorted
                if (arr[mid] <= target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }

    // ------------------------------------------------------------------------

    // Recursive approach
    // Time Complexity: O(log n) - Binary Search
    // Space Complexity: O(log n) - Recursive stack space

    static int search2(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // search space exhausted
        }

        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[left] <= arr[mid]) {
            // left half is sorted
            if (arr[left] <= target && target <= arr[mid]) {
                return search2(arr, target, left, mid - 1);
            } else {
                return search2(arr, target, mid + 1, right);
            }
        } else {
            // right half is sorted
            if (arr[mid] <= target && target <= arr[right]) {
                return search2(arr, target, mid + 1, right);
            } else {
                return search2(arr, target, left, mid - 1);
            }
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int result = search(arr, target);
        System.out.println(result);
    }
}
