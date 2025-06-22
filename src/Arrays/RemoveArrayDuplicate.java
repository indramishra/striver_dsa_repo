package Arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveArrayDuplicate {
    public static void main (String[] args) {
        int[] arr = {1,1,2,3,4,4,5,5};
        int k = removeDuplicatesOptimized(arr);
       for(int i=0;i<k;i++) {
           System.out.print(arr[i]+" ");
       }
    }
    public static int removeDuplicateBruteForce(int[] arr) {
        Set<Integer> uniqueSet = new LinkedHashSet<Integer> ();
        for(int i=0;i<arr.length;i++) {
            uniqueSet.add (arr[i]);
        }
        int j = 0;
        for(Integer i : uniqueSet) {
            arr[j++] = i;
        }

        return uniqueSet.size ();
    }
   /*
   * use two pointers(temp indexes) approach, where first temp index(i) would 0th index, and second(j) would be from 1 to arr length.
   * Idea to shift all repeating values to right, so that we can get all unique values at left, i would be length of non-repeating array.
   * */
    public static int removeDuplicatesOptimized( int[] arr) {
        int i=0;
        for(int j=1; j < arr.length; j++) {
            if(arr[j]!=arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }
}
