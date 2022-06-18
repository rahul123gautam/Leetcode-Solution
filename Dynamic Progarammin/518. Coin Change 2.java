Problem Link:- https://leetcode.com/problems/coin-change-2/


 ******************CODE*****************
 
   class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][]dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }
        return findWays(n-1 , amount , coins , dp);
    }
    public int findWays(int ind , int target , int[]coins , int[][]dp){
        if(ind == 0){
            if(target % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int not_take = findWays(ind-1 , target , coins , dp);
        int take = 0;
        if(coins[ind] <= target) take = findWays(ind , target-coins[ind] , coins , dp);
        return dp[ind][target] = not_take + take;
    }
}
