package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 7, 2, 4};
        int size = arr.length;
        int[] sorted = bubbleRecursive(arr, arr.length, 0);
        for (int i = 0; i < size; i++) {
            System.out.print(sorted[i] + " ");
        }
    }

    public static int[] bubbleSort(int size, int[] arr) {
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start));
        return arr;
    }

    public static int[] bubbleRecursive(int[] arr, int size, int start) {
        if (size == 1) {
            return arr;
        }
        if (start < size -1) {
            if (arr[start] > arr[start + 1]) {
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            return bubbleRecursive(arr, size, start + 1);
        } else {
            return bubbleRecursive(arr, size - 1, 0);
        }
    }
}


