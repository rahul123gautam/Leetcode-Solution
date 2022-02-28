Problem Link :- https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/


You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
  
  
  
                               ********************CODE*********************
                               
  
   Stack<Pair<Character, Integer>> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
           if(!stack.isEmpty() && stack.peek().getKey() == ch) {
               stack.push(new Pair(ch, stack.pop().getValue()+1));
               if(stack.peek().getValue() == k) {
                   stack.pop();
               }
           } else {
               stack.push(new Pair(ch, 1));
           }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int value = stack.peek().getValue();
            for(int i=0; i<value; i++) {
                 sb.append(stack.peek().getKey());
            }
            stack.pop();
        }
        return sb.reverse().toString();
