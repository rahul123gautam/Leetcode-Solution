Problem Link:- https://leetcode.com/problems/out-of-boundary-paths/

There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n





                              ***************CODE***************
                              
  
  
  
  class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][]dp = new int[m][n][maxMove+1];
        for(int i = 0; i < m; i++){
           for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j] , -1);
           }
        }
        return findPaths(startRow , startColumn , m , n , maxMove , dp);
    }
    public int findPaths(int i , int j , int m , int n , int maxMove , int[][][]dp){
        if(i < 0 || j < 0 || i == m || j == n) return 1;
        if(maxMove == 0) return 0;
        if (dp[i][j][maxMove] >= 0) return dp[i][j][maxMove];
        int M = 1000000007;
        int vertical = (findPaths(i-1 , j , m , n , maxMove-1 , dp) + findPaths(i+1 , j , m , n , maxMove-1 , dp)) % M;
        int horizontal = (findPaths(i , j-1 , m , n , maxMove-1 , dp) + findPaths(i , j+1 , m , n , maxMove-1 , dp)) % M;
        dp[i][j][maxMove] = (vertical + horizontal)%M;
        return dp[i][j][maxMove];
    }
}
