Problem Link:- https://leetcode.com/problems/rotting-oranges/


You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
  
  
  
                        ************CODE************
                        
  
  class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0, freshOrange = 0;
        Queue<int[]>que = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    que.add(new int[]{i , j});
                }
                if(grid[i][j] == 1) freshOrange++;
            }
        }
        int[][]dir = {{0,1}, {0,-1}, {-1, 0}, {1, 0}};
        while(!que.isEmpty() && freshOrange > 0){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[]rotten = que.poll();
                for(int[]arr : dir){
                    int row = arr[0] + rotten[0];
                    int col = arr[1] + rotten[1];
                    if(col >= 0 && row >= 0 && col < n && row < m && grid[row][col] == 1){
                        freshOrange--;
                        grid[row][col] = 2;
                        que.add(new int[]{row , col});
                    }
                }
            }
            ans++;
        }
        return freshOrange == 0 ? ans : -1;
    }
}
