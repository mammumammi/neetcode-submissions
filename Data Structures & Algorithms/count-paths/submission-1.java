class Solution {
    public int uniquePaths(int m, int n) {
        // int[][] dp =new int[m][n];

        // for (int row = 0;row<m;row++)
        //     dp[row][0] = 1;

        // for (int col = 0;col<n;col++){
        //     dp[0][col] = 1;
        // }

        // for (int row = 1;row<m;row++){
        //     for (int col = 1;col<n;col++){
        //         dp[row][col] = dp[row-1][col] + dp[row][col - 1];
        //     }
        // }
        // return dp[m-1][n-1];
















        int[][] dp = new int[m][n];

        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }

        for (int i = 0;i<n;i++){
            dp[0][i] = 1;
        }

        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
