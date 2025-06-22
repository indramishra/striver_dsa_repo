package Arrays;

/**
 * problem: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.
 *Note: Two consecutive equal values are considered to be sorted.
 * */
public class CheckArraySorted {
    public static void main (String[] args) {
        int[] arr = {4,4,4,3};
        System.out.println ("is array sorted: "+checkSorted (arr));
    }
    public static boolean checkSorted(int[] arr){
        if(arr.length == 1) {
            return true;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }
}
