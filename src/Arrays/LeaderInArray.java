package Arrays;
/** <p>
 * problem: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all of the elements on its right side in the array.
 * </p>
 * Example:
 * <pre>
 *  Input:
 *  arr = [10, 22, 12, 3, 0, 6]
 *  Output:
 *  22 12 6
 *
 * Explanation:
 * 6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
*</pre>
* */
public class LeaderInArray {
    public static void main (String[] args) {
        int[] arr = {4, 7, 1, 0};
        printLadersInArray (arr);
    }
    public static void printLadersInArray(int[] arr) {
        int max = arr[arr.length-1];
        System.out.print (arr[ arr.length -1 ]+" ");
       for(int i=arr.length - 2;i>=0;i--) {
           if(arr[i] > max) {
               System.out.print (arr[i]+" ");
               max = arr[i];
           }
       }

    }
}
