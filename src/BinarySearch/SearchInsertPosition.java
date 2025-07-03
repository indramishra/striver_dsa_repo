package BinarySearch;

public class SearchInsertPosition {
    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,10};
        int target = 2;
        System.out.println (searchInsertPosition (arr, target));
    }
    public static int searchInsertPosition(int[] nums, int target) {
        int index = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (high + low)/2;
            if(target <= nums[mid]) {
                index = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}
