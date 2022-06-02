Problem Link:- https://leetcode.com/problems/house-robber-ii/


You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
  
  
                **************************CODE******************************
                
  
  class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[]dp1 = new int[n-1];
        int[]dp2 = new int[n-1];
        int[]temp1 = new int[n-1];
        int[]temp2 = new int[n-1];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++){
            if(i != 0) temp1[j++] = nums[i];
            if(i != n-1) temp2[k++] = nums[i];
        }
        Arrays.fill(dp1 , -1);
        Arrays.fill(dp2 , -1);
        return Math.max(maxMoney(n-2 , temp1 , dp1) , maxMoney(n-2 , temp2 , dp2));
    }
    public int maxMoney(int index , int[]nums , int[]dp){
        if(index == 0) return nums[index];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int pick = nums[index] + maxMoney(index-2 , nums , dp);
        int notPick = 0+ maxMoney(index-1 , nums , dp);
        dp[index] = Math.max(pick , notPick);
        return dp[index];
    }
}
