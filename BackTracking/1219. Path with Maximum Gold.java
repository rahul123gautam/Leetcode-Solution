Problem Link:- https://leetcode.com/problems/path-with-maximum-gold/


In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.
  
  
  
  
                               ***************************CODE*************************
                               
  
  
  class Solution {
    private boolean taken[][];
    private int m , n;
    public int getMaximumGold(int[][] grid) {
        m = grid.length ;
        n = grid[0].length;
        taken = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    int val = findMaxGold(grid , i , j );
                    if(val > ans) ans = val;
                }
            }
        }
        return ans;
    }
    public int findMaxGold(int[][]grid , int i , int j ){
        if(i < 0 || j < 0 || i == m || j == n) return 0;
        if(taken[i][j] || grid[i][j] == 0) return 0;
        taken[i][j] = true;
        int gold = grid[i][j];
        int max = Math.max(0 , findMaxGold(grid , i+1 , j));
        max = Math.max(max , findMaxGold(grid , i-1 , j));
        max = Math.max(max , findMaxGold(grid , i , j+1 ));
        max = Math.max(max , findMaxGold(grid , i , j-1 ));
        gold += max;
        taken[i][j] = false;
        return gold;
    }
}
