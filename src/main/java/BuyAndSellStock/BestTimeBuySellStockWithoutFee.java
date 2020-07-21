package BuyAndSellStock;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeBuySellStockWithoutFee {

    public int maxProfit(int prices[]) {
        if (prices == null || prices.length <= 1) return 0;

        int hold = -prices[0];
        int notHold = 0;
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i]);
        }

        return notHold;
    }

    public static void main(String[] args) {
        BestTimeBuySellStockWithoutFee bestTimeBuySellStock = new BestTimeBuySellStockWithoutFee();
        int prices[] = new int[]{7,1,5,3,6,4};
        System.out.println(bestTimeBuySellStock.maxProfit(prices));
    }

}