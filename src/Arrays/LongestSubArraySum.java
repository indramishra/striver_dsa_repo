package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * problem: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
 */
public class LongestSubArraySum {
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1};
        int sum = 5;
        System.out.println ("length of longest sub array of sum " + sum + " is: " + getLongestSubArrayLengthOfSumOptimized (arr, sum));
    }

    public static int getLongestSubArrayLengthOfSumBruteForce(int[] arr, int k) {
        int maxLen = 0;
        for(int i = 0; i < arr.length;i++) {
            int sum = 0;
            for(int j=i; j < arr.length;j++) {
                sum += arr[j];
                if(sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
   //optimized for positive inputs only
    public static int getLongestSubArrayLengthOfSumOptimized(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int sum = arr[0];

        while(right < arr.length) {
            if(left <= right && sum > k) {
                sum = sum - arr[left];
                left++;
            }
            if(sum == k) {
                maxLen = Math.max (maxLen, right - left + 1);
            }
            //
            right++;
            if(right < arr.length) {
              sum +=arr[right];
            }
        }
        return maxLen;
    }
    // optimized for positive inputs only, with extra if/else checks.
    public static int longestSubarray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int sum = nums[0];
        int maxLength = 0;

        while (i < nums.length && j < nums.length) {
            if (sum == k) {
                maxLength = Math.max(j - i + 1, maxLength);
                sum = sum - nums[i];
                i++;
                j++;
                if (j < nums.length) {
                    sum = sum + nums[j];
                }
            } else if (sum < k) {
                j++;
                if (j < nums.length) {
                    sum = sum + nums[j];
                }
            } else {
                    sum = sum - nums[i];
                    i++;
            }
        }

        return maxLength;
    }
    //optimized for positive and negative values.
    public static int getLongestSubArrayLengthWithNegativeElements(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<> ();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLen = Math.max (maxLen, i+1);
            }
            int remainder = sum - k;

            if(prefixSumMap.containsKey (remainder)) {
                maxLen = Math.max (maxLen, i - prefixSumMap.get (remainder));
            }

            if(!prefixSumMap.containsKey (sum)) {
                prefixSumMap.put (sum, i);
            }
        }
        return maxLen;
    }
}


