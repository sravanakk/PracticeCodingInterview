package Algorithms.BinarySearch;

/**
 * User: Sravana Kumar K
 * Date: 10-11-2018 10:43 PM
 */
public class FindOccurences {

    private static int firstOccurence(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (arr[mid] == key && (mid == 0 || arr[mid-1] < key)) {
                return mid;
            } else if (arr[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int lastOccurence(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
           mid = low + (high - low) / 2;
           if (arr[mid] == key && (mid == arr.length - 1 || arr[mid+1] > key)) {
               return mid;
           } else if (arr[mid] <= key) {
               low = mid + 1;
           } else {
               high = mid - 1;
           }
        }
        return -1;
    }

    private static int occurencesCount(int[] arr, int key) {
        int first = firstOccurence(arr, key);
        int last = lastOccurence(arr, key);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 6, 7 };

        int key = 2;
        System.out.println("First Occurence of " + key + " is " + firstOccurence(arr, key));
        System.out.println("Last Occurence of " + key + " is " + lastOccurence(arr, key));
        System.out.println("Number of Occurence for " + key + " is " + occurencesCount(arr, key));
    }
}
