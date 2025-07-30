package BinarySearch;

/**
 * <p>
 *     problem: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
 * </p>
 * <pre>
 *     Example:
 *      Input Format: N = 3, M = 27
 *      Result: 3
 *  Explanation: The cube root of 27 is equal to 3.
 * </pre>
 */
public class FindNthRoot {
    public static void main (String[] args) {
        int n = 3;
        int m = 81;
        System.out.println (n+"th root of number "+m+" would be "+findNthRoot (n, m));

    }
    public static int findNthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while(low <= high) {
            int mid = (low + high)/2;
            double num = Math.pow (mid,n);
            if(num == m) {
                return mid;
            }
            if(num > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
