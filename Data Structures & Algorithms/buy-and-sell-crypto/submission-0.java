class Solution {
    public int maxProfit(int[] prices) {
        int buy,sell;
        buy = 0;
        sell = 1;
        int max = 0;
        while(buy != prices.length - 1){
            if (prices[sell] - prices[buy] > max){
                max = prices[sell] - prices[buy];
            }
            if (sell != prices.length - 1) sell++;
            else {
                buy++;
                sell = buy + 1;
            }

        }
        return max;
        
    }
}
