package BinarySearch;

/**
 * <p>
 * problem: You're given an sorted array arr of n integers and an integer x. Find the floor and ceiling of x in arr[0..n-1].
 * The floor of x is the largest element in the array which is smaller than or equal to x.
 * The ceiling of x is the smallest element in the array greater than or equal to x.
 * <p>
 * <pre>
 *     Example:
 *     Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
 *     Result: 4 7
 *    Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
 * </pre>
 */
public class FindCielFloor {
    public static void main (String[] args) {
        int[] arr = { 3, 4, 4, 7, 8, 10 };
        int k = 5;
        findCielFloor (arr, k);
    }

    public static void findCielFloor (int[] arr, int k) {
        System.out.print (findFloor (arr, k, 0, arr.length - 1) + " ");
        System.out.print (findCiel (arr, k, 0, arr.length - 1));
    }

    // The ceiling of x is the smallest element in the array greater than or equal to x.
    public static int findCiel (int[] arr, int k, int start, int end) {
        if (start > end) {
            return k;
        }
        int mid = start + (end - start) / 2;
        if (arr[ mid ] >= k) {
            return arr[ mid ];
        }
        if (k < arr[ mid ]) {
            return findCiel (arr, k, start, mid - 1);
        } else {
            return findCiel (arr, k, mid, end);
        }
    }

    // The floor of x is the largest element in the array which is smaller than or equal to x.
    public static int findFloor (int[] arr, int k, int start, int end) {
        int floor = - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[ mid ] <= k) {
                floor = arr[ mid ];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floor;
    }
}

