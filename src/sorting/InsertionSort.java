package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,1,5,2};
        int[] sorted = insertionSort(arr);
        for(int i = 0; i <= sorted.length - 1; i++) {
            System.out.print(" "+sorted[i]+" ");
        }
    }
    public static int[] insertionSort(int[] arr) {
       long start = System.nanoTime();
        for (int i = 1; i <= arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
            for(int k = 0; k < arr.length ; k++) {
                System.out.print(" "+arr[k]+" ");
            }
            System.out.println("");
        }
        long end = System.nanoTime();
        System.out.println("Time taken: "+(end - start));
        return arr;
    }
}
