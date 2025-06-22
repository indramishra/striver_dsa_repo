package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayRecursion {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[]{2,5,3,7}));
        sortArray(arr);
        arr.forEach(System.out::print);
    }
    public static void sortArray(List<Integer> arr) {
         if(arr.size() == 1) {
             return;
         }
        int temp = arr.removeLast();
        sortArray(arr);
        insert(arr, temp);
    }


    public static void insert(List<Integer> arr, int temp) {
        if(arr.isEmpty() || arr.getLast() <= temp) {
            arr.addLast(temp);
            return;
        }
        int val = arr.removeLast();
        insert(arr, temp);
        arr.addLast(val);

    }
}
