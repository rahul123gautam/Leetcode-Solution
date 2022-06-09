Problem link:- https://leetcode.com/problems/minimum-falling-path-sum/


Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
  
  
   ********************CODE********************
   
  // Tabulation 

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

// Recursion + Memoizatin

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][]dp = new int[n][n];
        for(int[]x : dp){
            Arrays.fill(x , -1);
        }
        for(int j = 0; j < n; j++){
            ans = Math.min(ans , findPath(matrix , 0 , j , dp));
        }
        return ans;
    }
    public int findPath(int[][]matrix , int i , int j , int[][]dp){
        int n = matrix.length;
        if(j < 0 || j >= n) return 100000;
        if(i == n-1) return matrix[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int down = matrix[i][j] + findPath(matrix , i+1 , j , dp);
        int downLeft = matrix[i][j] + findPath(matrix , i+1 , j-1 , dp);
        int downRight = matrix[i][j] + findPath(matrix , i+1 , j+1 , dp);
        return dp[i][j] = Math.min(down , Math.min(downLeft , downRight));
    }
}
