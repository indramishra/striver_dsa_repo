package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main (String[] args) {
        int[] arr = {1,5,6,2,8,9};
        int elem = 5;
        int elem1 = 10;
        System.out.println ("is element "+elem+" available in the array? "+searchElement (arr, elem));
        System.out.println ("is element "+elem1+" available in the array? "+searchElement (arr, elem1));
    }

    public static boolean searchElement(int[] arr, int element) {
        Arrays.sort (arr);
        return binarySearch(arr, element, 0, arr.length-1);
    }
    // Binary search requires array to be sorted
    public static boolean binarySearch(int[] arr, int element, int start, int end) {
        if(start > end) {
            return  false;
        }
        int mid = (end + start)/2;
        if(element == arr[mid]) {
            return  true;
        } else if(element > arr[mid]) {
           return binarySearch (arr, element, mid+1, end);
       } else {
           return binarySearch (arr, element, start, mid-1);
       }

    }
}
