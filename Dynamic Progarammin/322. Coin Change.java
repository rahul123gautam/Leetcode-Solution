Problem Link- https://leetcode.com/problems/coin-change/


 ******************CODE********************
 
   
   // Approach - 1

class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        makeCoin(coins , amount , 0 , 0 , 0);
        return ans;
    }
    public void makeCoin(int[]coins , int amount , int sum , int amountOfCoins , int index){
        if(index == coins.length) return;
        if(sum == amount){
            ans = ans < amountOfCoins ? ans : amountOfCoins;
        }
        for(int i = index; i < coins.length; i++){
            if(sum + coins[i] <= amount){
                makeCoin(coins , amount , sum+coins[i] , amountOfCoins+1 , i);
            }else{
                makeCoin(coins , amount , sum , amountOfCoins , i+1);
            }
            sum = sum-coins[i];
        }
    }
}



// Approach - 2



class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][]dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }
        int val = findWays(n-1 , amount , coins , dp);
        if(val == 100000) return -1;
        return val;
    }
    public int findWays(int ind , int target , int[]coins , int[][]dp){
        if(ind == 0){
            if(target % coins[0] == 0) return target/coins[0];
            return 100000;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int not_take =findWays(ind-1 , target , coins , dp);
        int take = 100000;
        if(coins[ind] <= target) take =1 + findWays(ind , target-coins[ind] , coins , dp);
        return dp[ind][target] = Math.min(not_take , take);
    }
}
