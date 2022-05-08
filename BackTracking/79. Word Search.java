Problem Link:- https://leetcode.com/problems/word-search/



Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
  
  
  
  
  
  
                         **************************CODE***************************
                         
  
  
  class Solution {
    private boolean tempBoard[][];
    private int m , n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        tempBoard = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(searchWord(board , word , 0 , i , j)) return true;
                }
            }
        }
        return false;
    }
    public boolean searchWord(char[][]board , String word , int idx , int idx1 , int idx2){
        if(idx1 >= m || idx2 >= n || idx1 < 0 || idx2 < 0) return false; 
        if(board[idx1][idx2] != word.charAt(idx) || tempBoard[idx1][idx2]) return false;
        if(idx == word.length()-1) return true;
        tempBoard[idx1][idx2] = true;
        boolean found = searchWord(board , word , idx+1 , idx1+1 , idx2) || searchWord(board , word , idx+1 , idx1-1 , idx2)||searchWord(board , word , idx+1 , idx1 , idx2+1)||searchWord(board , word , idx+1 , idx1 , idx2-1);
        tempBoard[idx1][idx2] = false;    
        return found;
    }
}
