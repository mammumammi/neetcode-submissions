class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null || grid[0].length == 0) return 0;
        int islandCount = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int r = 0;r<row;r++){
            for (int c = 0;c<col;c++){
                if (grid[r][c] == '1'){
                    islandCount++;

                    islandDFS(r,c,grid);
                }
            }
        }

        return islandCount;
    }

    private void islandDFS(int r,int c,char[][] grid){
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == '0')
        return;

        grid[r][c] = '0';

        islandDFS(r+1,c,grid);
        islandDFS(r-1,c,grid);
        islandDFS(r,c+1,grid);
        islandDFS(r,c-1,grid);


    }
}
