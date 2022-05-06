Problem Link:- https://leetcode.com/problems/max-area-of-island/



You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
  
  
                                               *****************************CODE*****************************
                                               
  
  
  class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length , maxArea = 0;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    int val = dfs(grid , i , j , row , col);
                    if(val > maxArea) maxArea = val;
                }
            }
        }
        return maxArea;
    }
    public int dfs(int [][]grid , int i , int j , int row , int col){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        int area = 1;
        area += dfs(grid , i+1 , j , row , col);
        area += dfs(grid , i-1 , j , row , col);
        area += dfs(grid , i , j+1 , row , col);
        area += dfs(grid , i , j-1 , row , col);
        return area;
    }
}
