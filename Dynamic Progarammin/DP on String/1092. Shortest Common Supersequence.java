Problem Link:- https://leetcode.com/problems/shortest-common-supersequence/




Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

 

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
  
  
  
  
   ************************CODE*************************
   
  
  
  
  class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length() , m = str2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        int i = n, j = m;
        String s = "";
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s = str1.charAt(i-1) + s;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                s = str1.charAt(i-1) + s;
                i--;
            } 
            else{
                s = str2.charAt(j-1) + s;
                j--;
            } 
        }
        while(i > 0) {
            s = str1.charAt(i-1) +s;
            i--;
        }
        while(j > 0) {
            s = str2.charAt(j-1) +s;
            j--;
        }
        return s;
    }
}
