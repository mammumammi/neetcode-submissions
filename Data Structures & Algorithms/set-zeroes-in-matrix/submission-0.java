class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i =0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if (matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i =0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                if(zeroRows.contains(i) || zeroCols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
