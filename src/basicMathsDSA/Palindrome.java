package basicMathsDSA;

public class Palindrome {
    public static void main(String[] args) {
        int n = 123;
        System.out.println("is "+n+" a palindrome?? "+isPalindromeOptimized(n));
    }

        public static String isPalindrome(int n) {
            if(n == reverse(n)) {
              return  "Yes";
            }
            return "No";
        }

        public static int reverse(int n) {
            int reverse = 0;
            while (n > 0) {
                int remainder = n % 10;
                n = n / 10;
                reverse = reverse*10 + remainder;
            }
            return reverse;
        }

    public static boolean isPalindromeOptimized(int n) {
        // Negative numbers and numbers ending with 0 (but not 0 itself) aren't palindromes
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (n > reversedHalf) {
            reversedHalf = reversedHalf * 10 + n % 10;
            n /= 10;
        }

        // For even-length numbers, n == reversedHalf
        // For odd-length, n == reversedHalf / 10
        return n == reversedHalf || n == reversedHalf / 10;
    }
}
