package BinarySearch;

/**
 *<p>
 *     problem: You are given a positive integer n. Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of 'sqrt(n)'.
 *</p>
 * <pre>
 *     Example:
 *       Input Format: n = 28
 *       Result: 5
 *    Explanation: Square root of 28 is approximately 5.292. So, the floor value will be 5.
 * </pre>
 */
public class FindFloorSqrt {
    public static void main (String[] args) {
        int num = 120;
        System.out.println ("the square root of the given number "+num+" is: "+floorSqrt (num));
    }
    public static int floorSqrt(int num) {
       int low = 1;
       int high = num;
       int sqrt = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(mid*mid <= num) {
                sqrt = mid;
                low = mid+1;
            } else {
               high = mid - 1;

            }

        }

        return sqrt;
    }
}
