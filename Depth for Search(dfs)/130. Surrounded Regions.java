Problem link:- https://leetcode.com/problems/surrounded-regions/


Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
  
  
  
                        ***********************************CODE************************************
                        
  
  class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m-1 || j == n - 1){
                    dfs(board , i , j);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == '1') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    public void dfs(char[][] board , int i , int j ){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        if(board[i][j]== 'X' || board[i][j] == '1') return;
        board[i][j] = '1';
        dfs(board , i+1 , j);
        dfs(board , i-1 , j);
        dfs(board , i , j-1);
        dfs(board , i , j+1);
    }
}
