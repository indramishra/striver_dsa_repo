package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{ 12, 11, 13, 5, 6, 7,0 };
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("Given array is");
        printArray(arr);


        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
    public static void merge(int[] arr, int left, int mid, int right) {
       int sizeOfLeftArr = (mid - left + 1);
       int sizeOfRightArr = (right - mid);
       int[] leftArr = new int[sizeOfLeftArr];
       int[] rightArr = new int[sizeOfRightArr];
       for(int i=0; i<sizeOfLeftArr; ++i) {
           leftArr[i] = arr[left+i];
       }
        for(int i=0; i<sizeOfRightArr; ++i) {
            rightArr[i] = arr[mid+1+i];
        }

       int i=0;
       int j=0;
       int k = left;

       while(i<sizeOfLeftArr && j<sizeOfRightArr) {
           if(leftArr[i] <= rightArr[j]) {
               arr[k] = leftArr[i];
               i++;
           } else {
               arr[k] = rightArr[j];
               j++;
           }
           k++;
       }

       while (i<sizeOfLeftArr) {
           arr[k] = leftArr[i];
           i++;
           k++;
       }

       while(j<sizeOfRightArr) {
           arr[k] = rightArr[j];
           j++;
           k++;
       }

    }

    public static void sort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);

            merge(arr, left, mid, right);
        }
    }

    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
