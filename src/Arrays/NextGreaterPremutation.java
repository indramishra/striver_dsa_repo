package Arrays;
/**
* problem: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
* If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).
 * example:
 * Input format: Arr[] = {1,3,2}
 * Output: Arr[] = {2,1,3}
* */
public class NextGreaterPremutation {
    public static void main (String[] args) {
        int[] arr = {1,2,3};
        arr = nextLexicographicallyGreaterPermutation (arr);
        for(int elem : arr) {
            System.out.print (elem+" ");
        }
    }
    public static int[] nextLexicographicallyGreaterPermutation(int[] arr) {
        int index = -1;
        int arrLen = arr.length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        /*
        * find the break-point index(first index) which identifies the position where we can increase the number to get a greater permutation.
        * */
        for(int i = arrLen-2; i >=0; i--) {
            if(arr[i] < arr[i+1]) {
                index = i;
                break;
            }
        }
        //if there is no break-point exists, that means array is non-increasing from the end, that indicates the premutation is highest possible, so return the smallest permutation
        if(index == -1) {
            reverseArray (arr, 0, arrLen - 1);
            return  arr;
        }
        // find the smallest index from the right of break-point index, which is greater to break-point index and swap
        for(int i = arrLen - 1; i >= index; i--) {
            if(arr[i] > arr[index]) {
                int diff = arr[ i ] - arr[ index ];
                if (min > diff) {
                    min = diff;
                    minIndex = i;
                }
            }
        }

        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;
        // reverse the sub-array, right of break-point index to get next greater permutation
        reverseArray (arr, index + 1, arrLen-1);
        return  arr;
    }
    public static void reverseArray(int[] arr,int start, int arrLen) {

        if(start >= arrLen) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[arrLen];
        arr[arrLen] = temp;
       reverseArray (arr, start+1, arrLen-1);
    }
}
