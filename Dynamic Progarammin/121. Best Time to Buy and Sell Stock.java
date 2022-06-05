Problem Linnk:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/


You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
  
  
         *******************CODE*********************
         
  
  //Approach - 1

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0 , n = prices.length , maxProfit = 0;
        for(int i = n-1; i >= 0; i--){
            if(i != n-1){
                int temp = prices[i];
                prices[i] = max - temp;
                if(max < temp) max = temp;
                if(prices[i] > maxProfit) maxProfit = prices[i];
            }else max = prices[i];
        }
        return maxProfit;
    }
}


//Approach - 2
class Solution {
    public int maxProfit(int[] prices) {
        int buyStock = prices[0];
        int maxProfit = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            profit = prices[i] - buyStock;
            buyStock = Math.min(buyStock , prices[i]);
            maxProfit = Math.max(maxProfit , profit);
        }
        return maxProfit;
    }
}
