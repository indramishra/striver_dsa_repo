package BinarySearch;

/**
 * <p>
 *     problem: You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *     Return the single element that appears only once.
 * </p>
 * <pre>
 *     Example 1:
 *      Input: nums = [1,1,2,3,3,4,4,8,8]
 *      Output: 2
 * </pre>
 */
public class SingleElementInSortedArray {
    public static void main (String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,5,6,6};
        System.out.println ("single element found in the given array: "+searchSingleElementInSortedArray (arr));
    }
    public static int searchSingleElementInSortedArray(int[] arr) {
        int start = 1, end = arr.length - 2;
        if(arr.length == 1 || (arr[0] != arr[1])) {
            return arr[0];
        }
        if(arr[arr.length -1] != arr[arr.length - 2]) {
            return arr[arr.length -1];
        }

        while(start <= end) {
            int mid = start + (end - start)/2;

            if((arr[mid] != arr[mid - 1]) && (arr[mid] != arr[mid + 1])) {
                return arr[mid];
            }
            //if mid is at the odd position in the given array, and it's left element is equals to mid's element or vice versa, then repeating elements are at left
            if((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                // then eliminate left part of the array from the mid
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return  -1;
    }
}
