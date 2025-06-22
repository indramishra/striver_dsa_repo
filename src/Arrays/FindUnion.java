package Arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindUnion {
    public static void main (String[] args) {
        int[] arr1 = {25, 50, 100};
        int[] arr2 = {10, 50, 100, 200};
        //System.out.println ("element found: "+ searchElement (arr1, 7, 0, arr1.length));
        System.out.println (findUnionOptimized (arr1, arr2));
    }

    /**
    * Approach: merge both of the given arrays, into a tree set, which will place unique elements from both of the arrays into the set, which will be union of the arrays, and tree map will place elements in sorted order.
     * Time Complexity: O((m+n)*logk), where n- size of arr1, m size of arr2, and k- size of set
     * Space Complexity: O(k)
    * */
    public static Set<Integer> findUnion(int[] arr1, int[] arr2) {

        return Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
                .collect(Collectors.toCollection (TreeSet::new));
    }

    /**
     * Approach: iterate both of the arrays, and place unique values into array list and check for duplicate values while placing into array list.
     * Time Complexity: O(m+n)
     * Space Complexity: O(k)
    * */
    public static List<Integer> findUnionOptimized(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<> ();
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                if(union.isEmpty () || union.getLast () != arr1[i]) {
                    union.add (arr1[i]);
                }
                i++;
            } else {
                if(union.isEmpty () || union.getLast () != arr2[j]) {
                    union.add (arr2[j]);
                }
                j++;
            }
        }
        while(i < arr1.length) {
            if(union.getLast () != arr1[i]) {
                union.add (arr1[i]);
            }
            i++;
        }
        while(j < arr2.length) {
            if(union.getLast () != arr2[j]) {
                union.add (arr2[j]);
            }
            j++;
        }
     return union;
    }
}