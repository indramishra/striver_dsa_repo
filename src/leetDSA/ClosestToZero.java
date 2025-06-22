/*
 * Given an integer array nums of size n, return the number with the value closest to 0 in nums.
 * If there are multiple answers, return the number with the largest value.
 * */

package leetDSA;

public class ClosestToZero {
    public static void main(String[] args) {
        int[] nums = {1,-1,-4,8,9};
        int result = findClosestNumber(nums);
        System.out.println(result);
    }
    public static int findClosestNumber(int[] nums) {
        int distance = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < distance || nums[i] == Math.abs(distance)) {
                distance = Math.abs(nums[i]);
                result = nums[i];
            }

        }
        return result;
    }

}
