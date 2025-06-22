package sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7,0};
        int[] arr1 = quickSort(arr, 0, arr.length - 1);
        for (int elem : arr1) {
            System.out.print(" " + elem + " ");
        }
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        qs(arr, low, high);
        return arr;
    }
    public static void qs(int[] arr, int low, int high) {
        if(low < high) {
            int partition = getPartition(arr, low, high); //get partition index to break the array into left and right halves
            qs(arr, low, partition-1);
            qs(arr, partition+1, high);
        }
    }
    public static int getPartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int pivotLeft = low; // use temp index to keep left(smaller to pivot) of the array
        int pivotRight = high; // use temp index to keep right(larger to pivot) of the array


        while(pivotLeft < pivotRight) {
            while(arr[pivotLeft] <= pivot && pivotLeft <= high - 1) { // move left to right
                pivotLeft++;
            }
            while(arr[pivotRight] > pivot && pivotRight >= low + 1) {// move left to left
                pivotRight--;
            }
            if(pivotLeft < pivotRight) { // swap smaller to left and larger to right until left temp index is less than right temp index
                int temp = arr[pivotLeft];
                arr[pivotLeft] = arr[pivotRight];
                arr[pivotRight] = temp;
            }
        }
        //swap the pivot when right temp index became equal to or less than left temp index
        int temp = arr[low];
        arr[low] = arr[pivotRight];
        arr[pivotRight] = temp;
        // return partition
        return pivotRight;

    }
}