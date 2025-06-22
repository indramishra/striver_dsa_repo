package Arrays;

import java.util.HashMap;
import java.util.Map;

class MajorityElementInArray {
    public static void main (String[] args) {
      int[] nums = {1,2,2,2,2,2,3,3,4};
        System.out.println ("majority element in the given array: "+majorityElementCheck (nums));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<> ();
        int n = nums.length;
        int maxLen = 0;
        int majorityElem = 0;
        for(int num : nums) {
        freqMap.merge(num, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(maxLen < entry.getValue()) {
                maxLen = entry.getValue();
                majorityElem = entry.getKey ();

            }
        }
        if(maxLen > n/2) {
          return majorityElem;
        }
        return -1;
    }
    // Optimizing the approach by applying Moor's voting algo
    public static int majorityElementOptimized(int[] arr) {
        int freqCount = 0;
        int elem = 0;
        // in this loop we are selecting which element have probably majority frequency
        for(int i=0; i< arr.length; i++) {
            if(freqCount == 0) {
                elem = arr[i];
                freqCount = 1;
            } else if(elem == arr[i]) {
                freqCount++;
            } else {
                freqCount--;
            }
        }

        // this loop will check, if selected element have frequency more than N/2(array size/2) or not
        int majorityCount = 0;
        for(int i=0; i< arr.length;i++) {
            if(elem == arr[i]) {
                majorityCount++;
            }
        }
        if(majorityCount > arr.length/2) {
            return  elem;
        }
        return -1;
    }

    public static int majorityElementCheck(int[] nums) {
        int count = 0;
        int num = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
            }

            if (num == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return num;
    }
}