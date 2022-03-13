Problem Link:- https://leetcode.com/problems/number-of-matching-subsequences/




Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
  
  
  
  
                                               **********************************************************************************
                                               *****************************************CODE*************************************
                                               
  class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String , Integer>map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i] , map.getOrDefault(words[i] , 0)+1);
        }
        for(String p : map.keySet()){
            int j = 0;
            int k = 0;
            while(k < s.length() && j < p.length()){
                if(p.charAt(j) == s.charAt(k)){
                    j++;
                    k++;
                }else k++;
            }
            if(j == p.length()){
                count += map.get(p);
            }
        }
        return count;
    }
}
