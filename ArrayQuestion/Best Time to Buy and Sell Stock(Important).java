   Problem Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/



                        ******************CODE******************
                        
                          ******************TIME COPLEXITY-N***************
                          
                          
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[]dp = new int[n];
        int max = prices[n- 1];
        for(int i = n -2; i >= 0; i--){
            int val = prices[i];
            if(max < val){
                dp[i] = 0;
                max = val;
            }else{
                dp[i] = max - val;
            }
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
