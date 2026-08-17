class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        int buy = Integer.MAX_VALUE;
        //buy once at lowest and sell at highest
        for (int i = 0;i<n;i++){
            buy = Math.min(buy,prices[i]); 

            int currentProfit = prices[i] - buy;

            if (currentProfit > maxProfit) maxProfit = currentProfit;
        }

        return maxProfit;
    }
}
