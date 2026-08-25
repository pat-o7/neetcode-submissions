class Solution {
    public int maxProfit(int[] prices) {

        // [10,11,1,6,7,6,4,5]
        // [5,100,1,200,3,4,7,6]
        // [1,2,3,4,5,6,7,9,10]

        int best = 0;

        int lowestBuy = prices[0];
        int sell = 1;
        while (sell < prices.length) {
            best = Math.max(best, prices[sell] - lowestBuy);
            lowestBuy = Math.min(prices[sell], lowestBuy);
            sell++;
        }



        return best;        
    }
}
