package BinarySearch;

/**
 * <p>
 *     problem: You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
 * </p>
 *
 * <pre>
 *     Example:
 *      Input: N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
 *      Output: 4
 *    Explanation: 3 is occurring 4 times in the given array so it is our answer.
 * </pre>
 */
public class CountOccurrences {
    public static void main (String[] args) {
        int[] arr = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int target = 3;
        System.out.println ("occurrence of the target "+target+" in the given array is: "+countOccurrencesOptimized (arr, target));
    }
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            if(arr[start] == target) {
                count++;
            }
            start++;
            if(arr[end] == target) {
                count++;
            }
            end --;
        }
        return count - 1;
    }

    public static int countOccurrencesOptimized(int[] arr, int target) {
        int firstOccur = binarySearch(arr, target, true);
        int lastOccur  = binarySearch(arr, target, false);

        return lastOccur - firstOccur+1;
    }

    public static int binarySearch(int[] arr, int target, boolean findFirst) {
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
