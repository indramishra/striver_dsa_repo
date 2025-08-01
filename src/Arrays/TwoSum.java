package Arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *     Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 *   You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *   You can return the answer in any order.
 * </p>
 *
 * <pre>
 *     Example :
 *      Input: nums = [2,7,11,15], target = 9
 *      Output: [0,1]
 *    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * </pre>
 */
public class TwoSum {
    public static void main (String[] args) {
        int[] arr = {1,3,5,7};
        int k = 6;
        System.out.println ("is two sum of "+k+" exists in the given array? "+getTwoSumOptimized (arr, k));
    }
    public static String twoSumBruteForce (int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int temp = k - arr[ i ];
            while(j < arr.length) {
                if(temp == arr[j]) {
                    return Arrays.toString (new int[]{i,j});
                }
                j++;
            }

        }
        return Arrays.toString (new int[]{-1,-1});
    }

    public static String getTwoSumWithHash(int[] arr, int k) {
        Map<Integer, Integer> twoSumMap = new HashMap<> ();
        for(int i =0; i < arr.length; i++) {
            if(twoSumMap.containsKey (k - arr[i])) {
                return "["+twoSumMap.get (k - arr[i])+", "+i +"]";
            }
            twoSumMap.put (arr[i], i);
        }

        return "["+-1+", "+-1+"]";
    }
   //This optimized approach only applicable we do not have to return two sum indices. Because we have sorted the array
    public static String getTwoSumOptimized(int[] arr, int k) {
        Arrays.sort (arr);
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            if(arr[left] + arr[right]== k) {
                return "Yes";
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return "No";
    }

}
