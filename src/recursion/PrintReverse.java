package recursion;

public class PrintReverse {
    public static void main(String[] args) {
        String str = "hello";
        Object[] charArr = str.chars().mapToObj(i -> (char) i).toArray();
        int size = charArr.length;
        Integer[] arr = {1,2,3,4,5};
        printInReverse(arr, arr.length);
        System.out.println();
        printInReverse(charArr, size);
    }
    public static <T> void printInReverse(T[] arr, int size) {
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        if(size > 0) {
            System.out.printf(arr[size - 1]+"");
            printInReverse(arr, size - 1);
        }
    }
}
