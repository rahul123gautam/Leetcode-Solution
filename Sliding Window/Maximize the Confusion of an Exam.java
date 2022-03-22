Problem Link:- https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.

 

Example 1:

Input: answerKey = "TTFF", k = 2
Output: 4
Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
There are four consecutive 'T's.
Example 2:

Input: answerKey = "TFFT", k = 1
Output: 3
Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
In both cases, there are three consecutive 'F's.
Example 3:

Input: answerKey = "TTFTTFTT", k = 1
Output: 5
Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT". 
In both cases, there are five consecutive 'T's.
 

Constraints:

n == answerKey.length
1 <= n <= 5 * 104
answerKey[i] is either 'T' or 'F'
1 <= k <= n




                                                  *********************************************************************
                                                  
  
  class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 0, end = 0 , n = answerKey.length() , max = 0 , mostFreq = 0;
        HashMap<Character ,Integer>map = new HashMap<>();
        while(end < n){
            char ch = answerKey.charAt(end);
            map.put(ch , map.getOrDefault(ch , 0)+1);
            mostFreq = Math.max(mostFreq , map.get(ch));
            if((end - start + 1) - mostFreq > k){
                char c = answerKey.charAt(start);
                map.put(c , map.get(c) - 1);
                start++;
            }
            max = Math.max(max , end-start+1);
            end++;
        }
        return max;
    }
}
