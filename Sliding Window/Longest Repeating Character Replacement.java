Problem Link:- https://leetcode.com/problems/longest-repeating-character-replacement/

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
  
  
                     ***************************CODE****************************
                     
  class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0 , n = s.length() , max = 0 , mostFreq = 0;
        HashMap<Character ,Integer>map = new HashMap<>();
        while(end < n){
            char ch = s.charAt(end);
            map.put(ch , map.getOrDefault(ch , 0)+1);
            mostFreq = Math.max(mostFreq , map.get(ch));
            if((end - start + 1) - mostFreq > k){
                char c = s.charAt(start);
                map.put(c , map.get(c) - 1);
                start++;
            }
            max = Math.max(max , end-start+1);
            end++;
        }
        return max;
    }
}
