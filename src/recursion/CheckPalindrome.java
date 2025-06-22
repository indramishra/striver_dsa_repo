package recursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println("is palindrome: "+palindromeCheck("abca"));
    }
    public static boolean palindromeCheck(String str) {
        if(str.isEmpty()) {
            return true;
        }
        if(str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
       return palindromeCheck(str.substring(1, str.length() - 1));

    }
}
