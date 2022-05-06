problem Link:- https://leetcode.com/problems/number-of-islands/


Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
  
  
                                     ************************CODE***********************
                                     
  
  class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int no_of_islands = 0 ;
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    find_no_of_island(grid , i , j , row , col);
                    no_of_islands++;
                }
            }
        }
        return no_of_islands;
    }
    public void find_no_of_island(char[][]grid , int i , int j , int row , int col){
        if(i < 0 || j < 0 || i == row || j == col || grid[i][j] != '1') return;
        grid[i][j] = '2';
        find_no_of_island(grid , i+1 , j , row , col);
        find_no_of_island(grid , i-1 , j , row , col);
        find_no_of_island(grid , i , j+1 , row , col);
        find_no_of_island(grid , i , j-1 , row , col);
    }
}
