package BinarySearch;

/**
 * <p>
 * problem: Given a sorted array of N integers and an integer x, write a program to find the lower bound and Upper bound of x.
 * </p>
 * <pre>
 *     Example:
 *      Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 15
 *      Result: lower bound 15
 *              upper bound 19
 *    Explanation: Index 3 lower bound and index 4 in upper bound  such that arr[3] >= x and arr[4] > x
 * </pre>
 */
public class LowerBound {
    public static void main (String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 };
        int k = 15;
        System.out.println ("lower bound of " + k + " in the given arr: " + implementLowerBound (arr, k));
        System.out.println ("Upper bound of " + k + " in the given arr: " + implementUpperBound (arr, k));
    }

    public static int implementLowerBound (int[] arr, int k) {
        return getLowerBound (arr, k, 0, arr.length - 1);
    }

    public static int implementUpperBound (int[] arr, int k) {
        return getUpperBound (arr, k, 0, arr.length - 1);
    }

    private static int getUpperBound (int[] arr, int k, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(arr[mid] > k) {
            return arr[mid];
        }
        if(k < arr[mid]) {
            return getUpperBound (arr, k, start, mid-1);
        } else {
            return getUpperBound (arr, k, mid+1, end);
        }

    }


    public static int getLowerBound (int[] arr, int k, int start, int end) {
        if (start > end) {
            return - 1;
        }
        int mid = start + (end - start) / 2;
        // return if lower bound found, A lower bound of a given target is the first position in a sorted array where the element is greater than or equal to the target.
        if (arr[ mid ] >= k) {
            return arr[ mid ];
        }
        if (k > arr[ mid ]) {
            return getLowerBound (arr, k, mid, end);

        } else {
            return getLowerBound (arr, k, start, mid - 1);
        }
    }


}

