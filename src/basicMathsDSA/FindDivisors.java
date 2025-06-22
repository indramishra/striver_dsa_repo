package basicMathsDSA;

import java.util.*;

public class FindDivisors {
    public static void main(String[] args) {
        int n = 16;
        System.out.println("divisors for "+n+" are "+divisors(n));
    }
        public static List<Integer> divisors(int n) {
            List<Integer> divisors = new ArrayList<Integer>();
            divisors.add(1);
            for(int i=2; i <= Math.sqrt(n);i++) {
                if(n%i == 0) {
                    divisors.add(i);
                    if(i != n/i && n/i != n) { //to add pair divisors( e.g. for number 16 - 1 is a pair of 16, 2 is a pair of 8 etc.)
                        divisors.add(n/i);
                    }
                }

            }
            divisors.add(n);
            return divisors;
        }
}
