package recursion;

public class SumNumbers {
    public static void main(String[] args) {
        int n = -2;
        System.out.println("sum of "+n+" numbers is: "+NnumbersSum(n));
    }
    public static int NnumbersSum(int n) {
        //your code goes here
        if(n == 0) {
            return 0;
        }
        if(n < 0) {
            return n + NnumbersSum(n+1);
        }
        return n + NnumbersSum(n-1);
    }
}
