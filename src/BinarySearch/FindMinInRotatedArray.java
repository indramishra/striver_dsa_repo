package BinarySearch;

/**
 * <p>
 *     problem: Given an integer array arr of size N, sorted in ascending order (with distinct values). Now the array is rotated between 1 to N times which is unknown. Find the minimum element in the array.
 * </p>
 *
 * <pre>
 *     Example:
 *      Input Format: arr = [3,4,5,1,2]
 *      Result: 1
 *   Explanation: Here, the element 1 is the minimum element in the array.
 * </pre>
 */
public class FindMinInRotatedArray {
    public static void main (String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println ("minimum element in the given rotated array: "+ findMinInRotatedArray (arr));
    }
    public static int findMinInRotatedArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end) {
            //if array is already sorted even after rotation
            if(arr[start] <= arr[end]) {
                min = Math.min(min, arr[start]);
                return min;
            }
            int mid = start + (end - start)/2;
            //if left part of the mid(<= mid), is sorted then left most would be minimum
            if(arr[start] <= arr[mid]) {
                min = Math.min(min, arr[start]);
                start = mid + 1;
            } else { // if right of the mid is sorted then left most after the mid would be minimum
                min = Math.min (min, arr[mid]);

                end = mid - 1;
            }
        }
        return min;
    }
}
