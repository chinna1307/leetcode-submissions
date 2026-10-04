class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int price : prices) {
            minprice = Math.min(price, minprice);
            int profit = price - minprice;
            maxprofit = Math.max(profit, maxprofit);
        }
        return maxprofit;
    }
}