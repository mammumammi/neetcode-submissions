class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int island = 0;

        for (int i =0;i<grid.length;i++){
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    island++;
                    int islandArea = islandDFS(i,j,grid);
                    maxArea = Math.max(maxArea,islandArea);
                }
            }
        }
        return (island > 0) ? maxArea : 0;
    }

    private int islandDFS(int r,int c,int[][] grid){
        if (r<0 || r>=grid.length || c <0 || c >= grid[0].length || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        
        return 1 + islandDFS(r,c+1,grid) + islandDFS(r,c-1,grid) + islandDFS(r+1,c,grid) + islandDFS(r-1,c,grid);
    }
}
