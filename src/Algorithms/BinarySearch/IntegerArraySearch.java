package Algorithms.BinarySearch;

import java.util.Arrays;

/**
 * User: Sravana Kumar K
 * Date: 10-11-2018 09:40 PM
 */
public class IntegerArraySearch {

    private static int iterativeBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int recursiveBinarySearch(int[] arr, int key, int low, int high) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] > key) {
            return recursiveBinarySearch(arr, key, low, mid-1);
        } else if (arr[mid] < key) {
            return recursiveBinarySearch(arr, key, mid+1, high);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 4, 7};

        int key = 2;

        // Calling Iterative Methog
        System.out.println(key + " is found at position " + iterativeBinarySearch(arr, key));

        // Calling Recursive Methog
        System.out.println(key + " is found at position " + recursiveBinarySearch(arr, key, 0, arr.length-1));

        // Calling Collections Methog
        System.out.println(key + " is found at position " + Arrays.binarySearch(arr, key));
    }
}
