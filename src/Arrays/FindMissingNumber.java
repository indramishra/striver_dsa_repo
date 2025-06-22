package Arrays;

import java.util.Arrays;

/**
 * problem: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
 */
public class FindMissingNumber {
    public static void main (String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        int lastNum = 5;
        System.out.println ("missing number is: " + findMissingOptimized (arr, lastNum));
    }

    //approach will work when array is sorted
    public static int findMissing (int[] arr, int lastNum) {
        int missingNum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[ i - 1 ] + 1 != arr[ i ]) {
                missingNum = arr[ i - 1 ] + 1;
            }
        }
        return missingNum;
    }

    // using summation approach, calculate expected sum(sum of 1 to num), actual sum(sum of given array elements), missing number would be difference between expected sum and actual sum
    public static int findMissingOptimized (int[] arr, int num) {
        int expectedSum = num * (arr[ 0 ] + num) / 2;
        int actualSum = Arrays.stream (arr).sum ();
        return expectedSum - actualSum;
    }
}
