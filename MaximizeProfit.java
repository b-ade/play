public class MaximizeProfit{
    public static void main(String[] args) {
        int[] prices = {9,11,8,5,7,10};
        System.out.println("Maximum profit possible from one trade is "+findOptimumBuyAndSellDays(prices));
    }

    static int findOptimumBuyAndSellDays(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-2; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > maxProfit)
                    maxProfit = prices[j] - prices[i];
            }
        }
        return maxProfit;
    }
}