class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultSet = new ArrayList<>();

        int rows = heights.length;
        int col = heights[0].length;

        boolean[][] pacific = new boolean[rows][col];
        boolean[][] atlantic = new boolean[rows][col];

        for (int c = 0;c<col;c++){
            dfs(0,c,pacific,heights,heights[0][c]);
            dfs(rows -1,c,atlantic,heights,heights[rows-1][c]);
        }

        for (int r = 0;r<rows;r++){
            dfs(r,0,pacific,heights,heights[r][0]);
            dfs(r,col-1,atlantic,heights,heights[r][col-1]);
        }

        for (int r=0;r<rows;r++){
            for(int c = 0;c<col;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    resultSet.add(Arrays.asList(r,c));
                }
            }
        }

        return resultSet;
    }

    private void dfs(int r,int c,boolean[][] oceanGrid,int[][] heights,int prevHeight){
        if (r<0 || c<0|| r>=heights.length || c>=heights[0].length ) return;

        if (oceanGrid[r][c] || heights[r][c] < prevHeight) return;

        oceanGrid[r][c] = true;

        dfs(r+1,c,oceanGrid,heights,heights[r][c]);
        dfs(r-1,c,oceanGrid,heights,heights[r][c]);
        dfs(r,c+1,oceanGrid,heights,heights[r][c]);
        dfs(r,c-1,oceanGrid,heights,heights[r][c]);
    }
}
