class Solution {
    HashMap<Integer,Set<Character>> boxes = new HashMap<>();
    HashMap<Integer,Set<Character>> rows = new HashMap<>();
    HashMap<Integer,Set<Character>> cols = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        

        for (int i = 1;i<10;i++){
            boxes.put(i,new HashSet<>());
        }
        boolean result = true;
        //9x9 2+2<5 2+5<8 // 3+3 = 6 3 + 6 = 9 3 + 9 = 12
        int row = board.length;int col = board[0].length;
        for (int i = 0;i<row;i++){
            rows.putIfAbsent(i,new HashSet<>());
            for (int j = 0;j<col;j++){
                cols.putIfAbsent(j,new HashSet<>());
                result = checkSudoku(i,j,board);
                if(!result) return false;
            }
        }
        return result;
    }

    private boolean checkSudoku(int i,int j,char[][] board){
        char value = board[i][j];
        if (value == '.') return true;
        if (rows.get(i).contains(value) || cols.get(j).contains(value)) return false;
        rows.get(i).add(value);
        cols.get(j).add(value);
        int box = 0;
        if (i < 3 && j < 3) box = 1;
        else if (i < 6 && j < 3) box = 2;
        else if (i < 9 && j < 3) box = 3;
        else if (i < 3 && j<6) box=4;
        else if (i < 6 && j<6) box = 5;
        else if (i<9 && j<6) box = 6;
        else if (i<3 && j<9) box = 7;
        else if (i<6 && j<9 ) box=8;
        else box = 9;
        if (boxes.get(box).contains(value)) return false;
        boxes.get(box).add(value);

        return true;
    }
}
