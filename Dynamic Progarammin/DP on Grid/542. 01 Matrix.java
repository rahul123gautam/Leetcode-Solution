Problem Link:- https://leetcode.com/problems/01-matrix/


Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
  
  
              *****************CODE******************
              
  
  class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length , col = mat[0].length;
        int[][]resultMat = new int[row][col];
        int maxValue = row*col;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0) continue;
                resultMat[i][j] = maxValue;
                if(i > 0){
                    resultMat[i][j] = Math.min(resultMat[i][j] , resultMat[i-1][j]+1);
                }
                if(j > 0){
                     resultMat[i][j] = Math.min(resultMat[i][j] , resultMat[i][j-1]+1);
                }
            }
        }
        
        for(int i = row-1; i >= 0; i--){
            for(int j = col-1; j >= 0; j--){
                if(mat[i][j] == 0) continue;
                if(i < row-1){
                    resultMat[i][j] = Math.min(resultMat[i][j] , resultMat[i+1][j]+1);
                }
                if(j < col-1){
                     resultMat[i][j] = Math.min(resultMat[i][j] , resultMat[i][j+1]+1);
                }
            }
        }
        return resultMat;
    }
}
