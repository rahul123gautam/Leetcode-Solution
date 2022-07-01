Problem Link:- https://leetcode.com/problems/interleaving-string/


Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 

Follow up: Could you solve it using only O(s2.length) additional memory space?
  
  
                             ******************CODE**************
                             
  
   // Recursion + Memoizatin
  
  class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if((n1 + n2 < n3) || (n1 + n2 > n3)){
            return false;
        }
        Boolean[][]dp = new Boolean[n1+1][n2+1];
        return check(0, 0, s1, s2, s3, dp);
    }
    public boolean check(int ind1, int ind2, String s1, String s2, String s3, Boolean[][]dp){
        if(ind1 == s1.length() && ind2 == s2.length()) return true;
        if(dp[ind1][ind2] != null) return dp[ind1][ind2];
        char ch3 = s3.charAt(ind1 + ind2);
        if(ind1 < s1.length() && ch3 == s1.charAt(ind1)){
            if(check(ind1+1, ind2, s1, s2, s3,dp)) return dp[ind1][ind2] = true;
        }
        if(ind2 < s2.length() && ch3 == s2.charAt(ind2)){
            if(check(ind1, ind2+1, s1, s2, s3,dp)) return dp[ind1][ind2] = true;
        }
        return  dp[ind1][ind2] = false;
    }
}
