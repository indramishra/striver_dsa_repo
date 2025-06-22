package Arrays;

public class BuySellStocks {
    public static void main (String[] args) {
        int[] arr = {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println ("max profit: "+maxProfit (arr));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int start = 0;
        for(int i=1; i < prices.length; i++) {
            if(prices[i] <= prices[start] ) {
                start = i;
            }
            maxProfit = Math.max(prices[i] - prices[start], maxProfit);
        }
        return maxProfit;
    }
}
