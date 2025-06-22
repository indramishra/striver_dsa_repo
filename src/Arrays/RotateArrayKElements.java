package Arrays;

import java.util.Arrays;

/**
 * problem: Given an array of integers, rotating array of elements by k elements either left or right.
 *
* */
public class RotateArrayKElements {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5};
        Arrays.stream (rotateArrayByKElementsOptimized (arr,2,"left")).forEach (elem -> System.out.print(elem+" "));
    }
    public static int[] rotateArrayLeftByKElementsBruteForce(int[] arr, int k, String direction) {
        if(direction.equals ("left")) {
            for(int i=0; i< arr.length;i++) {
                if(i+k < arr.length) {
                    int temp = arr[ i ];
                    arr[ i ] = arr[ i + k ];
                    arr[ i + k ] = temp;
                }
            }
            for(int i=arr.length-k;i<arr.length-1;i++) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        if(direction.equals ("right")) {
            for(int i=arr.length-1;i>=0;i--) {
                if(i-k >=0) {
                    int temp = arr[ i - k ];
                    arr[ i - k] = arr[ i ];
                    arr[ i ] = temp;
                }
            }
            for(int i=0; i<k-1;i++) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        return arr;
    }

    public static int[] rotateArrayByKElementsOptimized(int[] arr, int k, String direction) {
        int n = arr.length;
        k = k%n;//to avoid the case when k > n.
        if(k == 0 || arr.length <=1) {
            return arr;
        }
        if(direction.equals ("left")) {
            reverse (arr,0,k-1);
            reverse (arr, k, n-1);
            reverse (arr,0, n-1);
        } else {
            reverse (arr,0,n-1);
            reverse (arr, 0, k-1);
            reverse (arr,k, n-1);
        }
        return  arr;
    }

    public static int[] reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
