package sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,1,5,2,0};
        int[] sorted = selectionSort(arr);
        for(int i = 0; i < sorted.length; i++) {
            System.out.print(" "+sorted[i]+" ");
        }
    }
    public static int[] selectionSort(int[] arr) {
        long start = System.nanoTime();
        for(int i=0; i < arr.length ;i++) {
            int min_index = i;
            for(int j = i+1; j< arr.length;j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }

            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;

            for(int k = 0; k < arr.length ; k++) {
                System.out.print(" "+arr[k]+" ");
            }
            System.out.println("");
        }
        long end = System.nanoTime();
        System.out.println("Time taken: "+(end - start));
        return arr;
    }

    public static int getMinIndex(int[] arr, int i, int j) {
        if(i == j) {
            return i;
        }
        int k = getMinIndex(arr, i+1, j);
        return arr[k] > arr[i] ? i : k;
    }

    public static  void selectionSortRecursive(int[] arr, int n, int index) {
        if(index == n) {
            return;
        }
        int k = getMinIndex(arr, index, n-1);
        if(k != index) {
            int temp = arr[k];
            arr[k] = arr[index];
            arr[index] = temp;
        }
        selectionSortRecursive(arr, n, index+1);
    }
}
