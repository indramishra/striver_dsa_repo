package Arrays;

import java.util.Arrays;

/**
* problem: Given an array of N integers, left rotate the array by one place.
 *
* */
public class RotateArrayLeft {
    public static void main (String[] args) {
        int[] arr = {1,1,2,3,4,5,6};
        Arrays.stream (rotateArrayLeftOptimized(arr)).forEach (elem ->System.out.print(elem+" "));
    }
    public static int[] rotateArrayLeftBruteForce(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
        return arr;
    }

    /*This approach eliminated swaps and only shifting of elements*/
    public static int[] rotateArrayLeftOptimized(int[] arr) {
        int i=0;
        int firstElem = arr[0];
        for(int j=1;j<arr.length;j++) {
            arr[i] = arr[j];
            i++;
        }
        arr[arr.length-1] = firstElem;
        return arr;
    }

}
