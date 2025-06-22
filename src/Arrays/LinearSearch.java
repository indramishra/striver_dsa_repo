package Arrays;

/**
 * problem: Given an array, and an element num the task is to find if num is present in the given array or not. If present print the index of the element or print -1.
 *
 */
public class LinearSearch {
    public static void main (String[] args) {
        int[] arr = {1,4,5,4,3,5};
        int element = 4;
        System.out.println ("index of found element: "+element+" in the array: "+findElement (arr, element));
    }
    public static int findElement(int[] arr, int element) {
        if(arr.length == 0 || (arr.length == 1 && arr[0] != element)) {
            return -1;
        }

        for(int i=0;i< arr.length;i++) {
            //if array will have duplicate values, it will return index of duplicate value occurs first
            if(arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
