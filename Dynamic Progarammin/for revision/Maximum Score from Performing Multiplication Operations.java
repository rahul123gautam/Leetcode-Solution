Problem Link:- https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/



You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

 

Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.
Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score. 
The total score is 50 + 15 - 9 + 4 + 42 = 102.
 

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
  
  
        ************************CODE***********************
        
  
  
  class Solution {
    int[][]dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new int[multipliers.length][multipliers.length];
        for(int i = 0; i < multipliers.length; i++){
            Arrays.fill(dp[i] , -2);
        }
        return maxScore(0 , 0 , nums.length-1 , nums , multipliers);
    }
    public int maxScore(int ind , int start , int end , int[]nums , int[]multipliers){
        if(ind >= multipliers.length) return 0;
        if(dp[ind][start] != -2) return dp[ind][start];
        int left = multipliers[ind]*nums[start] + maxScore(ind+1 , start+1 , end ,  nums , multipliers);
        int right = multipliers[ind]*nums[end] + maxScore(ind+1 , start , end-1 , nums , multipliers);
        return dp[ind][start] = Math.max(left , right);
    } 
}
