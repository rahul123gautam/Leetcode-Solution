Problem Link:- https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/


Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

 

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 

Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters.
  
  
                                                   ****************************************************************************************
                                                   **************************************CODE**********************************************
                                                   
  class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        long total = 0;
        int m = s1.length() , n = s2.length();
        for(int i = 0; i < m; i++) total += (int)s1.charAt(i);
        for(int i = 0; i < n; i++) total += (int)s2.charAt(i);
        long[][]dp = new long[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j== 0) dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = s1.charAt(i-1)*2l + dp[i-1][j-1];
                else dp[i][j] =Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return (int)(total - dp[m][n]);
    }
}
