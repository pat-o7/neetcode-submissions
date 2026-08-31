class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int profit = 0; // best profit so far

        if (prices.length == 1) {
            return 0;
        }

        // while there are days left to sell
        while (sell < prices.length) {
            // if the sell is higher than the buy
            if (prices[buy] < prices[sell]) {
                profit = Math.max(profit, prices[sell] - prices[buy]);
                sell++;
            } else {
                // if the sell is not higher than the buy
                buy = sell;
                sell++;
            }
        }
        return profit;
    }
}
