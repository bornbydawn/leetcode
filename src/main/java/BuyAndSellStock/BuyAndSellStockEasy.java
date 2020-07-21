package BuyAndSellStock;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BuyAndSellStockEasy {
    public int maxProfit(int[] prices) {

        if(prices.length <= 1) return 0;
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                maxProfit =  Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuyAndSellStockEasy buyAndSellStockEasy = new BuyAndSellStockEasy();
        int prices[] = new int[]{7,1,5,3,6,4};
        System.out.println(buyAndSellStockEasy.maxProfit(prices));
    }
}
