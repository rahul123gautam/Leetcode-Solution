Problem Link:- https://leetcode.com/problems/battleships-in-a-board/



               *******************CODE*******************
               
               
               
     class Solution {
    public int countBattleships(char[][] board) {
        int ans = 0;
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'X'){
                    ans++;
                    dfs(board , i , j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][]board, int i , int j){
        int m = board.length;
        int n = board[0].length;
        board[i][j] = '.';
        if(i > 0 && board[i-1][j] == 'X') dfs(board , i-1 , j);
        if(i < m-1 && board[i+1][j] == 'X') dfs(board , i+1 , j);
        if(j > 0 && board[i][j-1] == 'X') dfs(board , i , j-1);
        if(j < n-1 && board[i][j+1] == 'X') dfs(board , i , j+1);
    }
}
