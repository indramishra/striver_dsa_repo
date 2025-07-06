package BinarySearch;

/**
 * <p>
 *     problem: Given an integer array arr of size N, sorted in ascending order (with distinct values) and a target value k. Now the array is rotated at some pivot point unknown to you. Find the index at which k is present and if k is not present return -1.
 * </p>
 * <pre>
 *     Example:
 *      Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
 *      Result: 4
 *    Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.
 * </pre>
 */
public class SearchInRotatedSortedArray {
    public static void main (String[] args) {
        int[] arr = {4,5,5,6,7,0,1,2,3,3};
        int target = 0;
        System.out.println ("position of the given target "+target+" in the rotated array is: "+searchInRotatedSortedArrayWithDuplicates (arr, target));
    }
    public static int searchInRotatedSortedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1, index = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) {
                index = mid;
            }
            //check if left side of the array is sorted
            if(arr[start] <= arr[mid]) {
                //check if target is on the left side of array
                if(arr[start] <= target && arr[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid +1;
                }
            } else {
                // if right side of the array is sorted, then check if target is in right part of the array
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return index;
    }

    public static boolean searchInRotatedSortedArrayWithDuplicates(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == target) {
                return true;
            }
            //if duplicates then move
            if(arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start = start + 1;
                end = end -1;
            } else if (arr[ start ] <= arr[mid]) {
                if(arr[start] <= target && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }
}
