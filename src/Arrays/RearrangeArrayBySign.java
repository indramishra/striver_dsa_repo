package Arrays;
/**
* problem: There is an array ‘A’ of size ‘N’ with an equal number of positive and negative elements.
 *
 * Without altering the relative order of positive and negative numbers, you must return an array of alternative positive and negative values.
 *
 * Note:
 *
 * Start the array with a positive number.
* */
public class RearrangeArrayBySign {
    public static void main (String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        arr = rearrangeArrayOptimized(arr);
        for(int elem : arr) {
            System.out.print (elem+" ");
        }
    }
    public static int[] rearrangeArrayBruteForce(int[] nums) {
        int mid = nums.length/2;
        int[] positiveArray = new int[mid];
        int[] negativeArray = new int[mid];
        int positiveIndex = 0;
        int negativeIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                negativeArray[negativeIndex++] = nums[i];
            } else {
                positiveArray[positiveIndex++] = nums[i];
            }
        }
        positiveIndex = 0;
        negativeIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
                nums[i] = positiveArray[positiveIndex++];
            } else {
                nums[i] = negativeArray[negativeIndex++];
            }

        }
        return nums;
    }
    //Optimized with two pointers array
    public static int[] rearrangeArrayOptimized(int[] nums) {
        int posIndex = 0;
        int negIndex = 1;
        int[] arrangedArray = new int[nums.length];
        for(int i=0; i<nums.length;i++) {
            if(nums[i] < 0) {
                arrangedArray[negIndex] = nums[i];
                negIndex += 2;
            } else {
                arrangedArray[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return arrangedArray;
    }

}
