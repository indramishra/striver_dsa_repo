package Arrays;

import sorting.QuickSort;

/**
 * problem: Given an array of integers nums, return the value of the largest element in the array
 * constraints:
 * 1. 1 <= nums.length <= 105
 * 2. -104 <= nums[i] <= 104
 * 3. nums may contain duplicate elements.
 */
public class LargestElement {
    public static void main (String[] args) {
        int[] arr = { 1, 4, 3, 6, 8, 7, 8, 2, 9, 9 };
        System.out.println ("largest element of the array: " + findLargestOptimized (arr));
        System.out.println ("second largest element of the array: " + findSecondLargestOptimized1 (arr));
    }

    public static int findLargestBruteForce (int[] arr) {
        //sort the array first
        mergeSort (arr, 0, arr.length - 1);
        return arr[ arr.length - 1 ];
    }

    public static int findSecondLargestBruteforce (int[] arr) {
        mergeSort (arr, 0, arr.length - 1);
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[ i ] != arr[ arr.length - 1 ]) {
                return arr[ i ];
            }
        }
        return 0;
    }

    public static int findLargestOptimized (int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[ i ]) {
                max = arr[ i ];
            }
        }
        return max;
    }

    public static int findSecondLargestOptimized1 (int[] arr) {
        int largest = 0;
        int secondLargest = - 1;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[ i ]) {
                largest = arr[ i ];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[ i ] < largest && secondLargest < arr[ i ]) {
                secondLargest = arr[ i ];
            }
        }
        return secondLargest;

    }

    public static int findSecondLargestOptimized2 (int[] arr) {
        int largest = 0;
        int secondLargest = - 1;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[ i ]) {
                secondLargest = largest;
                largest = arr[ i ];
                // If current number is smaller than the largest but greater than the current second largest,
                // update secondLargest. Also make sure it's not equal to largest to avoid duplicate max values.
            } else if (secondLargest < arr[ i ] && arr[ i ] != largest) {
                secondLargest = arr[ i ];
            }
        }
        return secondLargest;

    }

    public static void mergeSort (int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort (arr, low, mid);
            mergeSort (arr, mid + 1, high);
            merge (arr, low, mid, high);
        }
    }

    public static void merge (int[] arr, int low, int mid, int high) {
        int leftArrSize = (mid - low + 1);
        int rightArrSize = (high - mid);

        int[] leftArr = new int[ leftArrSize ];
        int[] rightArr = new int[ rightArrSize ];
        for (int i = 0; i < leftArrSize; i++) {
            leftArr[ i ] = arr[ low + i ];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArr[ i ] = arr[ mid + 1 + i ];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[ i ] <= rightArr[ j ]) {
                arr[ k ] = leftArr[ i ];
                i++;
            } else {
                arr[ k ] = rightArr[ j ];
                j++;
            }
            k++;
        }
        while (i < leftArrSize) {
            arr[ k ] = leftArr[ i ];
            i++;
            k++;
        }
        while (j < rightArrSize) {
            arr[ k ] = rightArr[ j ];
            j++;
            k++;
        }

    }


}
