Problem Link:- https://leetcode.com/problems/cherry-pickup-ii/

                   ***********************CODE************************
                   
                     
class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][]dp = new int[row][col][col];
        for(int i= 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < col; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxCherryPickup(grid , 0 , 0 , col-1 , dp);
    }
    public int maxCherryPickup(int[][]grid , int i , int j1 , int j2 , int[][][]dp){
        int row = grid.length;
        int col = grid[0].length;
        if(j1 < 0 || j1 >= col || j2 < 0 || j2 >= col) return Integer.MIN_VALUE;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        if(i == row - 1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        int maxi = 0;
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                if(j1 == j2){
                    maxi = Math.max(maxi , grid[i][j1] + maxCherryPickup(grid , i+1 , j1 + dj1 , j2 + dj2 , dp));
                }else maxi = Math.max(maxi , grid[i][j1] + grid[i][j2] + maxCherryPickup(grid , i+1 , j1 + dj1 , j2 + dj2 , dp));
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}
