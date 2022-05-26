Problem Link:- https://leetcode.com/problems/minimum-window-substring/




Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
  
  
  
                   **************************CODE**********************
                   
  
  class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer>tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i) , tMap.getOrDefault(t.charAt(i) , 0)+1);
        }
        HashMap<Character , Integer>sMap = new HashMap<>();
        String ans = "";
        int ansLength = Integer.MAX_VALUE , j = 0;
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i) , sMap.getOrDefault(s.charAt(i) , 0)+1);
            while(j <= i && checkCondition(tMap , sMap)){
                if(ansLength > i - j + 1){
                    ans = s.substring(j , i+1);
                    ansLength = i- j + 1;
                }
                sMap.put(s.charAt(j) , sMap.getOrDefault(s.charAt(j) , 0)-1);
                j++;
            }
        }
        return ans;
    }
    public boolean checkCondition(HashMap<Character , Integer>tMap , HashMap<Character , Integer>sMap){
        for(char s : tMap.keySet()){
            if(!sMap.containsKey(s)) return false;
            else{
                if(tMap.get(s) > sMap.get(s)) return false;
            }
        }
        return true;
    }
}
