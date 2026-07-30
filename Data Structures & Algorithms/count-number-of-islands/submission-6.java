class Solution {
    int island = 0;
    public int numIslands(char[][] grid) {
        // BFS DFS graph methods 
        // DSA Functions or DSA Use cheyyunath
        // DSA Functions used here
        
        if (grid.length == 0) return 0;//boundary case

        island = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                if (grid[i][j] == '1'){
                    island++;
                    islandDFS(i,j,grid);
                }
            }
        }
        return island;
    }
    //grid[i][j]
    void islandDFS(int i,int j,char[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        islandDFS(i,j+1,grid);
        islandDFS(i,j-1,grid);
        islandDFS(i+1,j,grid);
        islandDFS(i-1,j,grid);
        
    }
}
