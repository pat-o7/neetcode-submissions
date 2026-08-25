class Solution {
    public int maxProfit(int[] prices) {

        // track best profit
        int best = 0;
        
        // track buy in price
        int buy = 0;

        // track sell out price
        int sell = 1;

        // increment sell out price
        while (sell < prices.length) {
            // if sell out price is lower than buy in price, update buy in price
            if (prices[sell] < prices[buy]) {
                buy = sell;

            // otherwise, calculate profit and compare
            } else {
                int profit = prices[sell] - prices[buy];
                best = Math.max(best, profit);
            }
            sell++;
        }
        return best;
    }
}
