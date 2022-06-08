Problem Link:-https://leetcode.com/problems/minimum-path-sum/submissions/



Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100





********************CODE*******************

// Tabulation Method


class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int i = 1; i < m; i++){
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(dp[i-1][j] < dp[i][j - 1]){
                    dp[i][j] = dp[i -1][j] + grid[i][j];
                }else{
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}


// Recursion + Memoization

class Solution {
    public int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return pathSum(grid , 0 , 0 , dp);
    }
    public int pathSum(int[][]grid , int i , int j , int[][]dp){
        int m = grid.length , n = grid[0].length;
        if(i >= m || j >= n) return 10000;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == m-1 && j == n-1) return grid[i][j];
        int right = grid[i][j] + pathSum(grid , i , j+1 , dp);
        int down = grid[i][j] + pathSum(grid , i+1 , j , dp);
        return dp[i][j] = Math.min(right , down);
    }
}
