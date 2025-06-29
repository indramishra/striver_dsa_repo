package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * problem: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * </p>
 *
 * <pre>
 *     Example 2:
 *      Input Format: N = 3, array[] = {1,2,3}, k = 3
 *      Result: 2
 *    Explanation: The subarrays that sum up to 3 are [1, 2], and [3].
 * </pre>
 */
public class CountSubArraySum {

    public static void main (String[] args) {
        int[] arr = { 1, 2, 1 };
        int[] arr1 = { 1, - 1, 2, 3, 2, 1, - 1, 5 };
        int sum = 3;
        int sum1 = 4;
        System.out.println ("count of subarrays of the given sum " + sum + " is: " + countSubArraySumPositiveOnly (arr, sum));
        System.out.println ("count of subarrays of the given sum " + sum1 + " is: " + countSubArraySumOptimized (arr1, sum1));
    }

    //This approach works for array having only positive elements
    public static int countSubArraySumPositiveOnly (int[] arr, int k) {
        int sum = 0, start = 0, end = 0, count = 0;

        while (end < arr.length) {
            sum += arr[ end ];
            //if sum is greater than k, then move start to right
            while (sum > k && start <= end) {
                sum -= arr[ start++ ];
            }
            if (sum == k) {
                count++;
            }
            end++;
        }
        return count;
    }

    public static int countSubArraySumOptimized (int[] arr, int k) {
        int prefixSum = 0, remaining = 0, count = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<> ();
        //when ever prefixSum is equals to k, this base condition will help to count
        prefixSumMap.put (0, 1);
        for (int i = 0; i < arr.length; i++) {
            //prefix sum is cumulative sum till the current index
            prefixSum += arr[ i ];
            /*
             * To find subarrays that sum to k, we use reverse logic based on prefix sums.
             * Suppose the current cumulative sum(prefix sum) is S, and we're looking for a subarray with sum k.
             * Then if there exists a previous prefix sum "remaining" such that:
             *     S - remaining = k,
             *     => remaining = S - k
             * This means: a subarray exists between the index after "remaining" and the current index with sum k.
             * So we check how many times (S - k) has occurred before using a hashmap.
             */
            remaining = prefixSum - k;
            count += prefixSumMap.getOrDefault (remaining, 0);
            //store prefix sum and its frequency
            prefixSumMap.put (prefixSum, prefixSumMap.getOrDefault (prefixSum, 0) + 1);
        }

        return count;
    }
}
