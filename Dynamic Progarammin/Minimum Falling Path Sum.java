Program Link:https://leetcode.com/problems/minimum-falling-path-sum/


                       *****************CODE*****************
                       
                         
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(j == 0){
                    int min = Math.min(matrix[i - 1][j] , matrix[i - 1][j + 1]);
                    matrix[i][j] = matrix[i][j] + min;
                }
                if(j == matrix[0].length - 1){
                    int min = Math.min(matrix[i - 1][j - 1] , matrix[i - 1][j]);
                    matrix[i][j] = matrix[i][j] + min;
                }
                if(j != 0 && j != matrix[0].length - 1){
                    int min = Math.min(matrix[i - 1][j - 1] , matrix[i - 1][j]);
                    min = Math.min(min , matrix[i - 1][j + 1]);
                    matrix[i][j] = matrix[i][j] + min;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = matrix.length - 1 ,j = 0 ; j < matrix[0].length; j++){
            System.out.print(matrix[i][j]);
            ans = Math.min(ans , matrix[i][j]);
        }
        return ans;
    }
}
