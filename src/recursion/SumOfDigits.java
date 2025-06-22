package recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        int number = 1234;
        int digitSum = digitSum(number);
        System.out.println(digitSum);
    }
    public static int digitSum(int number) {
        if(number == 0) {
            return 0;
        }
        return (number%10 + digitSum(number/10));
    }
}
