class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == '1'){
                    islands++;
                    dfsIslands(i,j,grid);
                }
            }
        }

        return islands;
    }

    public void dfsIslands(int r,int c,char[][] grid){
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';
        dfsIslands(r+1,c,grid);
        dfsIslands(r-1,c,grid);
        dfsIslands(r,c+1,grid);
        dfsIslands(r,c-1,grid);
    }
}
