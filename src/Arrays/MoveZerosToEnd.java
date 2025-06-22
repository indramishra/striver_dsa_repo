package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MoveZerosToEnd {
    public static void main (String[] args) {
        int[] arr = {1,0,2,0,0,3,0};
        Arrays.stream (moveZeroesToEndOptimized(arr)).forEach (elem -> System.out.print (elem+" "));
    }
    public static int[] moveZerosToEnd(int[] arr) {
        if(arr.length <= 0) {
            return arr;
        }


        for(int i = 0; i < arr.length;i++) {
            int j = 0;
            while(j < arr.length - 1) {
                if(arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                j++;
            }
        }


        return arr;
    }

    public static int[] moveZeroesToEndOptimized(int[] arr) {
        if(arr==null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int nonZeroIndex = 0;
        //Move all non zeroes at left.
        for(int i=0;i<arr.length;i++) {
            if(arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }
        //fill zero at remaining indexes
        while(nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
        return arr;
    }


}
