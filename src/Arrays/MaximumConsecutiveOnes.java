package Arrays;

public class MaximumConsecutiveOnes {
    public static void main (String[] args) {
        int[] arr = {1,0,1,1,0, 1,1,1};
        System.out.println ("max consecutive ones: "+maximumConsecutiveOnesOptimized (arr));
    }
    public static int maximumConsecutiveOnes(int[] arr) {
        int temp = 0;
        int maxCount = 0;
        for(int i=0; i<arr.length;i++) {
            while(i < arr.length && arr[i]==1) {
                temp++;
                if(maxCount < temp) {
                    maxCount = temp;
                }
                i++;
            }
            temp = 0;
        }
        return  maxCount;
    }

    public static int maximumConsecutiveOnesOptimized(int[] arr) {
        int temp = 0;
        int maxCount = 0;
        for (int i : arr) {
            if (i == 1) {
                temp++;
                if (maxCount < temp) {
                    maxCount = temp;
                }
            } else {
                temp = 0;
            }
        }
        return maxCount;
    }
}
