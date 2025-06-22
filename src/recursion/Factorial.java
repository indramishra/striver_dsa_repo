package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 4;
        int fact = findFactorial(n);
        System.out.print(fact);
    }
    public static int findFactorial(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0 || n==1) {
            return 1;
        }
       return n*findFactorial(n-1);
    }
}
