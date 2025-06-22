package basicMathsDSA;

public class ArmStrongNumber {
    public static void main(String[] args) {
        System.out.println("is ArmStrong: "+ isArmstrong(12));
    }
    public static boolean isArmstrong(int n) {
        int digits = (int) Math.log10(Math.abs(n)) + 1; //get the digit count in the given number
        int armStrongNumber = 0;
        int restoreN = n;
        while(restoreN > 0) {
            int temp = restoreN % 10;
            restoreN = restoreN / 10;
            armStrongNumber += (int) Math.pow(temp, digits);
        }
        return armStrongNumber == n;

    }
}
