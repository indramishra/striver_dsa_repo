package BinarySearch;

import java.util.Arrays;

/**
 * <p>
 *     problem: Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *     If target is not found in the array, return [-1, -1].
 *     You must write an algorithm with O(log n) runtime complexity.
 * </p>
 * <pre>
 *     Example:
 *      Input: nums = [5,7,7,8,8,10], target = 8
 *      Output: [3,4]
 * </pre>
 */
public class FirstLastOccurrence {
    public static void main (String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        System.out.print ("first and last occurrence of target element "+target+" in the given array are: ");
        System.out.print(Arrays.toString (findFirstLastOccurrence (arr, target)));
    }
    public static int[] findFirstLastOccurrence(int[] arr, int target) {
        int firstOccur = binarySearch(arr, target, true);
        int lastOccur = binarySearch(arr, target, false);
        return new int[]{firstOccur, lastOccur};
    }

    private static int binarySearch (int[] arr, int target, boolean findFirst) {
        int index = -1;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                index = mid;
                if(findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return index;
    }
}
