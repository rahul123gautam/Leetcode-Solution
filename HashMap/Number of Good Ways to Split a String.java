Problem Link:- https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

You are given a string s.

A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.

Return the number of good splits you can make in s.

 

Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
  
  
  
                                  ***************************************************************************
                                  ***********************************CODE************************************
                                  
  
  class Solution {
    public int numSplits(String s) {
        int count = 0;
        HashMap<Character , Integer>map1 = new HashMap<>();
        HashMap<Character , Integer>map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(i != 0)map2.put(ch , map2.getOrDefault(ch , 0)+1);
            else map1.put(ch , 1);
        }
        if(map1.size() == map2.size()) count++;
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            map1.put(ch , map1.getOrDefault(ch , 0) + 1);
            map2.put(ch , map2.getOrDefault(ch , 0) - 1);
            if(map2.get(ch) == 0) map2.remove(ch);
            if(map1.size() == map2.size()) count++;
        }
        return count;
    }
}
