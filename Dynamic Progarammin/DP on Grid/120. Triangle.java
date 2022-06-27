Problem Link:- https://leetcode.com/problems/triangle/


Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
  
  
               *****************CODE****************
               
  
  // Tabulation

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row];
         for(int i=0;i<triangle.get(row-1).size();i++){
             dp[i] =  triangle.get(row-1).get(i);   
         }
    
         for(int i=row-2;i>=0;i--){ 
              for(int j=0;j<triangle.get(i).size();j++){
                   dp[j] = triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
              }
         }
    
         return dp[0];
    }
}


// Recursion + Memoization


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][]dp = new int[n][n];
        for(int[]x : dp){
            Arrays.fill(x , -1);
        }
        return minPathSum(triangle , 0 , 0 , dp);
    }
    public int minPathSum(List<List<Integer>> triangle , int i , int j , int[][]dp){
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + minPathSum(triangle , i+1 , j , dp);
        int diagonal = triangle.get(i).get(j) + minPathSum(triangle , i+1 , j+1 , dp);
        return dp[i][j] = Math.min(down , diagonal);
    }
}
