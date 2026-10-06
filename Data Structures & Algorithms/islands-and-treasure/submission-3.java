class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == 0){
                    dfs(i,j,grid,0);
                }
            }
        }
    }

    private void dfs(int i,int j,int[][] grid,int dist){
        if (i<0 || i >= grid.length || j<0 || j>=grid[0].length ) return;

        if (grid[i][j] == -1) return;

        if (dist > 0 && dist>=grid[i][j]) return;

        grid[i][j] = dist;

        dfs(i+1,j,grid,dist+1);
        dfs(i,j+1,grid,dist+1);
        dfs(i-1,j,grid,dist+1);
        dfs(i,j-1,grid,dist+1);
    }
}
