class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;


        int islandCount = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if (grid[r][c] == '1'){
                    islandCount++;
                    sinkIslandDFS(r,c,grid);
                }
            }
        }
        return islandCount;
    }

    private void sinkIslandDFS(int r,int c,char[][] grid){
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0')
            return;
        
        grid[r][c] = '0';

        sinkIslandDFS(r+1,c,grid);
        sinkIslandDFS(r-1,c,grid);
        sinkIslandDFS(r,c+1,grid);
        sinkIslandDFS(r,c-1,grid);



    }
}
