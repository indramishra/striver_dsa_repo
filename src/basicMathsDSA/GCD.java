package basicMathsDSA;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number to find gcd");
        System.out.print("Enter your first number: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter your second number: ");
        int n2 = scanner.nextInt();
        System.out.println("gcd: "+gcd(n1, n2));
    }
        public static int gcd(int n1, int n2) {
            while(n1 != 0) {
                int temp = n1;
                n1 = n2 % n1;
                n2 = temp;

            }
            return n2;
        }
}
