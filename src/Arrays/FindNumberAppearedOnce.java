package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * problem: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
 */
public class FindNumberAppearedOnce {
    public static void main (String[] args) {
        int[] arr = { 2, 1, 1, 3, 3, 4, 4 };
        System.out.println ("number appeared once: " + findNumberAppearedOnceOptimized (arr));
    }

    public static int findNumberAppearedOnce (int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<> ();
        Arrays.stream (arr).forEach (elem -> frequencyMap.merge (elem, 1, Integer::sum));
        for (Map.Entry<Integer, Integer> map : frequencyMap.entrySet ()) {
            if (map.getValue () == 1) {
                return map.getKey ();
            }
        }
        return - 1;
    }



    /*
    *  This approach uses XOR, so XOR of a number itself in equals to 0, e.g. 1^1 = 0, and XOR of a number with zero would return number itself, 0^1 = 1
    * */
    public static int findNumberAppearedOnceOptimized (int[] arr) {
        int xorr = 0;
        for (int i : arr) {
            xorr = xorr ^ i;
        }
        return xorr;
    }
}
