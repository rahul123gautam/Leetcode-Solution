Problem link:- https://leetcode.com/problems/edit-distance/




Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
  
  
                                         *****************CODE*******************
                                         
  
  
  // Recursion + Memoization , T.C => O(n*m) , S.C => O(n*m) + O(Auxiliary Stack spcae(n + m));

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length();
        int[][]dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }
        return minimumDis(n-1 , m-1 , word1 , word2 , dp);
    }
    public int minimumDis(int i , int j , String word1 , String word2 , int[][]dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) return minimumDis(i-1 , j-1 , word1 , word2 , dp);
        int insert =  1 + minimumDis(i , j-1 , word1 , word2 , dp);
        int delete = 1 + minimumDis(i-1 , j , word1 , word2 , dp);
        int replace = 1 + minimumDis(i-1 , j-1 , word1 , word2 , dp);
        return dp[i][j] = Math.min(insert , Math.min(delete , replace));
    }
}


// Tabulation , T>C => O(n*m) , S.C => O(n*m);


class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length();
        int[][]dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                     int insert =  1 + dp[i][j-1];
                     int delete = 1 + dp[i-1][j];
                     int replace = 1 +dp[i-1][j-1];
                    dp[i][j] = Math.min(insert , Math.min(delete , replace));
                }
            }
        }
        return dp[n][m];
    }
}

// Tabultion + Space Optimization , T.C => O(n*m) , S.C => O(m);


class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length() , m = word2.length();
        int[]prev = new int[m+1];
        int[]cur = new int[m+1];
        for(int j = 0; j <= m; j++) prev[j] = j;
        for(int i = 1; i <= n; i++){
            cur[0] = i;
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) cur[j] = prev[j-1];
                else{
                     // int insert =  1 + prev[j];
                     // int delete = 1 + cur[j-1];
                     // int replace = 1 +prev[j-1];
                    cur[j] = 1 + Math.min(prev[j] , Math.min(cur[j-1] , prev[j-1]));
                }
            }
            prev = cur;
        }
        return prev[m];
    }
}
