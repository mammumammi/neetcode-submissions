class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int held = -prices[0];
        int sold= 0;
        int reset = 0;

        for (int i = 1;i<prices.length;i++){
            int preSold = sold;

            sold = held + prices[i];

            held = Math.max(held,reset - prices[i]);

            reset = Math.max(reset,preSold);
        }

        return Math.max(reset,sold);
    }
}
