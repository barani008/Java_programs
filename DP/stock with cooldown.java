class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if(days <= 1)
            return 0;
        int[] buy = new int[days];
        int[] sell = new int[days];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(buy[0]+prices[1], sell[0]);
        for(int i=2;i<days;i++){
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[days-1];
    }
}