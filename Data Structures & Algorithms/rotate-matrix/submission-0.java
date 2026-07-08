class Solution {
    public void rotate(int[][] matrix) {
        
        if (matrix.length == 0 || matrix.length == 1 || matrix == null){
            return ;
        }

        //transpose
        int n = matrix.length;
        for (int i = 0;i<n;i++){
            for (int j = i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i =0;i<n;i++){
            reverse(matrix[i]);
        }

    }
    private void reverse(int[] arr){
        int left = 0;int right = arr.length - 1;
        while (left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            right--;
            left++;
        }
    }
}
