Problem Link:- https://leetcode.com/problems/wildcard-matching/


Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
  
  
  
  **************************************************CODE******************************************************
  
  
  
  
  class Solution {
    public boolean isMatch(String s, String p) {
        int m = p.length() , n = s.length();
        int[][]dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }
        return  matching(m-1 , n-1 , p , s , dp) == 1;
    }
    public int matching(int i , int j , String p , String s , int[][]dp){
        if(i < 0 && j < 0) return 1;
        if(i < 0 && j >= 0) return 0;
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(p.charAt(k) != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') return dp[i][j] = matching(i-1 , j-1 , p , s , dp);
        if(p.charAt(i) == '*'){
            if(matching(i-1 , j , p , s , dp) == 1 || matching(i , j - 1, p , s , dp) == 1) return dp[i][j] = 1;
        }
        return dp[i][j] = 0;
    }
}
