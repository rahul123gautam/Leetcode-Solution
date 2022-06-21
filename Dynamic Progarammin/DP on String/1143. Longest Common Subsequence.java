Problem Link:- https://leetcode.com/problems/longest-common-subsequence/


Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
  
  
               ************************CODE**************************
               
  // ---------------Recursive + Memoization -----------------
  
  
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        int[][]dp = new int[n][m];
        for(int  i = 0; i < n; i++) Arrays.fill(dp[i] , -1);
        return longestSubsequence(n-1 , m-1 , text1 , text2 , dp);
    }
    public int longestSubsequence(int ind1 , int ind2 , String text1 , String text2 , int[][]dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)) return dp[ind1][ind2] = 1 + longestSubsequence(ind1-1 , ind2-1 , text1 , text2 , dp);
        return dp[ind1][ind2] = Math.max(longestSubsequence(ind1-1 , ind2 , text1 , text2 , dp) , longestSubsequence(ind1 , ind2-1 , text1 , text2 , dp));
    }
}

// -------- Tabulation -------- 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else{
                    if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                    else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
