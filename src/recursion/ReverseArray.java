package recursion;

public class ReverseArray {
    public static void main(String[] args) {
       int[] arr = new int[]{1,2,3,4,5};
        reverseArray(arr, arr.length);
    }
    public static void reverseArray(int[] arr, int n) {
        if(n == arr.length) {
            System.out.print("[");
        }
        if(n <= 0) {
            System.out.print(arr[n]);
            System.out.print("]");
            return;
        }
          if(n > 1) {
              System.out.print(arr[n - 1] + ",");
          }


        reverseArray(arr, n-1);


    }
}
