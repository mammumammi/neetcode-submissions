class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        
        int islands = 0;
        for (int i =0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == '1'){
                    islands++;
                    islandDFS(i,j,grid);
                }
            }
        }
        return islands;
    }

    private void islandDFS(int r,int c,char[][] grid){
        if (r < 0 || r >= grid.length || c <0 || c >= grid[0].length || grid[r][c] == '0') return;

        grid[r][c] = '0';
        islandDFS(r,c+1,grid);
        islandDFS(r,c-1,grid);
        islandDFS(r+1,c,grid);
        islandDFS(r-1,c,grid);

        //[1,0,1,1,0,1,1]
    }
}
