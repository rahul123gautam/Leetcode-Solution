Problem Link:- https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/


Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
  
  
          *******************CODE*********************
          
  
  
  class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String s2 = "";
        for(int i = n-1; i >= 0; i--) s2 += s.charAt(i);
        int[][]dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return n - dp[n][n];
    }
}
