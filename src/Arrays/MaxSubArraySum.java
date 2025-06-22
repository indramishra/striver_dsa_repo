package Arrays;
/**
* problem:
* */
public class MaxSubArraySum {
    public static void main (String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println ("max sum of the array: "+maximumSubArrayAndSum (arr));
    }
    public static int maximumSubArraySum(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
       int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length;i++) {
            int sum = 0;
            for(int j = i; j < arr.length;j++) {
                sum +=arr[j];
                maxSum = Math.max (sum, maxSum);
            }
        }
        return maxSum;
    }
    // kadan's algorithm
    public static int maximumSubArraySumOptimized(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(sum < 0) {
                //return max sum in case we have only negative elements in the array.
                maxSum = Math.max (sum, maxSum);
                sum = 0;
            } else {
                maxSum = Math.max (sum, maxSum);
            }
        }
        return  maxSum;
    }

    public static int maximumSubArrayAndSum(int[] arr) {
        int subArrayStart = -1;
        int subArrayEnd = -1;
        int start = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++) {
            if(sum == 0) {
                start = i;
            }
            sum += arr[i];
            if(sum > maxSum) {
                subArrayStart = start;
                subArrayEnd = i+1;
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        System.out.print ("[");
        while(subArrayStart < subArrayEnd) {
            System.out.print (arr[subArrayStart]+",");
            subArrayStart +=1;
        }
        System.out.println ("]");
        return maxSum;
    }
}
