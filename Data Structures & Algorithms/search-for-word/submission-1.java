class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int r = 0;r<row;r++){
            for (int c = 0;c<col;c++){
                if (dfs(r,c,board,word,0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int row,int col,char[][] board,String word,int index){
        if ( index == word.length()){
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(index) != board[row][col]) return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(row,col + 1,board,word,index + 1) ||
                        dfs(row,col - 1,board,word,index+ 1) ||
                        dfs(row + 1,col,board,word,index+ 1) ||
                        dfs(row - 1,col,board,word,index+1 );

        board[row][col] = temp;

        return found;
    } 
}
