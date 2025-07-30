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
        int n = 2;
        int m = 81;
        System.out.println (n+"th root of number "+m+" would be "+findNthRootOptimized (n, m));

    }
    public static int findNthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while(low <= high) {
            int mid = (low + high)/2;
            //calculating power of mid might cause number overflow exception when given number m is too big, and we have to find nth root of given m,
            // so we just have to go till power of mid is equals to or less than given m.
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

    /**
     * <p>
     *     This method is optimized for calculating power of mid, there is a slight modification- we calculated power of mid till given m. For that we'll a custom power method
     * </p>
     * @param n
     * @param m
     * @return
     */
    public static int findNthRootOptimized(int n, int m) {
        int low = 1, high = m;
        while(low <= high) {
            int mid = (low + high)/2;
            int midN = pow(n,mid,m);
            if(midN == 1) {
                return mid;
            }
            if(midN == 2) {
                high = mid - 1;
            } else if(midN == 0) {
                low = mid + 1;
            }
        }
        return  -1;
    }

    /**
     * <p>
     *     This method will calculate the power of mid(POM), as soon as POM is greater than given m, return 2, if it's equals then return 1, if lesser then 0.
     * </p>
     * @param n
     * @param mid
     * @param m
     * @return
     */
    public static int pow(int n, int mid, int m) {
        long ans = 1;
        for(int i=1; i<=n;i++) {
            ans = ans*mid;
            if(ans > m) {
                return 2;
            }
        }
        if(ans == m) {
            return 1;
        }
        return 0;
    }
}
