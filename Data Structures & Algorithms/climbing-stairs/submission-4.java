class Solution {
    public int climbStairs(int n) {
        // n steps. 1 or 2 step at a time 1->2->4 1
        // 0->1 one way                            1->3->4 1
        // 0->2,1->2 two way 
        // [1,2,3,4,5]
        // 1->3 one+one = two way
        // 1->3 + 1->2 = 1->,2,3 = two ways
        //  3 step. 1->3,2->3 = one + two = two ways
        // 4 step 3->4,2->4
        // prev number of ways per one step + prev number of ways per two step

        int[] dp = new int[n + 1];
        //[1,2,3,4,5]
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
