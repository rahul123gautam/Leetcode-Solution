Problem Link:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
  
  
                   ***************************CODE***********************
                   
  
  // Recursion + Memoization


class Solution {
    public int maxProfit(int[] prices) {
        int[][][]dp = new int[prices.length][2][3];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxAns(0 , 1 , 2 , prices , dp , prices.length);
    }
    public int maxAns(int ind , int buy , int cap , int[]prices , int[][][]dp , int n){
        if(ind == n || cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        
        if(buy == 1){
            int take = -prices[ind] + maxAns(ind+1 , 0 , cap , prices , dp , n);
            int not_take = 0 + maxAns(ind+1 , 1 , cap , prices , dp , n);
            return dp[ind][buy][cap] = Math.max(take , not_take);
        }
        int take = prices[ind] + maxAns(ind+1 , 1 , cap-1 , prices , dp , n);
        int not_take = 0 + maxAns(ind+1 , 0 , cap , prices , dp , n);
        return dp[ind][buy][cap] = Math.max(take , not_take);
    }
}


// Tabulation


class Solution {
    public int maxProfit(int[] prices) {
        int[][][]dp = new int[prices.length+1][2][3];
        for(int ind = prices.length - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        int take = -prices[ind] + dp[ind+1][0][cap];
                        int not_take = dp[ind+1][1][cap];
                        dp[ind][buy][cap] = Math.max(take , not_take);
                    } 
                    else {
                        int take =  prices[ind] + dp[ind+1][1][cap-1];
                        int not_take = dp[ind+1][0][cap];
                        dp[ind][buy][cap] = Math.max(take , not_take);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}


// Tabulation + Memization

class Solution {
    public int maxProfit(int[] prices) {
        int[][]after = new int[2][3];
        int[][]cur = new int[2][3];
        for(int ind = prices.length - 1; ind >= 0; ind--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    if(buy == 1){
                        int take = -prices[ind] + after[0][cap];
                        int not_take = after[1][cap];
                        cur[buy][cap] = Math.max(take , not_take);
                    } 
                    else {
                        int take =  prices[ind] + after[1][cap-1];
                        int not_take = after[0][cap];
                        cur[buy][cap] = Math.max(take , not_take);
                    }
                }
            }
            after = cur;
        }
        return after[1][2];
    }
}
