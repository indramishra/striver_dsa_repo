package Arrays;

import java.util.Arrays;
/**
* problem: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
* */
public class SortZeroOnesTwos {
    public static void main (String[] args) {
        int[] arr = {2,1,0};
        sortZeroOnesTwos (arr);
        Arrays.stream (arr).forEach (elem -> System.out.print (elem+" "));
    }
    public static void sortZeroOnesTwos(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high) {
            switch (arr[mid]) {
                case 0:
                    swap (arr, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap (arr, mid, high--);
                    break;
            }
        }
    }

    public  static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
