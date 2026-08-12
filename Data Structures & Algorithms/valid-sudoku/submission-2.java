class Solution {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> boxes = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        // for (int i = 0;i<row;i++)
        //     rows.put(i,new HashSet<>());
        
        // for (int j = 0;j<col;j++)
        //     cols.put(j,new HashSet<>());

        // for (int i = 1;i<10;i++){
        //     boxes.put(i,new HashSet<>());
        // }
        for (int i =0;i<row;i++){
            for (int j = 0;j<col;j++){
                boolean result = isValid(i,j,board);
                if (!result) return false;
            }
        }
        return true;
    }
    private boolean isValid(int r,int c,char[][] board){
        char value = board[r][c];
        if (value == '.') return true;
        rows.putIfAbsent(r,new HashSet<>());
        cols.putIfAbsent(c,new HashSet<>());
        if (rows.get(r).contains(value) || cols.get(c).contains(value)) return false;

        rows.get(r).add(value);
        cols.get(c).add(value);

        int box = 0;
        if (r < 3 && c<3) box = 1;
        else if (r<6 && c<3) box = 2;
        else if (r<9 && c<3) box = 3;
        else if (r<3 && c<6) box = 4;
        else if (r<6 && c<6) box = 5;
        else if (r<9 && c<6) box = 6;
        else if (r<3 && c<9) box = 7;
        else if (r<6 && c<9) box = 8;
        else if (r<9 && c<9) box = 9;
        boxes.putIfAbsent(box,new HashSet<>());
        if (boxes.get(box).contains(value)) return false;

        boxes.get(box).add(value);
        return true;
    }
}
