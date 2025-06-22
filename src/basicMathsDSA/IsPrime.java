package basicMathsDSA;

public class IsPrime {
    public static void main(String[] args) {
        int n = 7;
        System.out.println("is "+n+" a prime number? "+isPrimeOptimized(n));
    }
    public static boolean isPrime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(i != n && n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeOptimized(int n) {
        if(n <= 1) return false; // eliminate 1 and lesser values.
        if(n == 2) return true; // 2 is prime.
        if(n%2 == 0) return false; // eliminate even numbers.
        int sqrt = (int)Math.sqrt(n);
        for(int i = 3; i<= sqrt; i+=2) {
            if(n%i == 0) return false;
        }
        return  true;
    }
}
