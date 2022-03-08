Problem linl :- https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
  
  
  
                                        ***************************************CODE********************************
                                        ***************************************************************************
                                        
                                        
 public String minRemoveToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        int open = 0, close = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
                open++;
            }else if(ch == ')'){
                if(open > 0){
                    st.push(ch);
                    open--;
                    close++;
                }
            }else st.push(ch);
        }
        StringBuilder p = new StringBuilder ();
        open = 0;
        close = 0;
        while(!st.isEmpty()){
            char ch = st.pop();
            if(ch == ')'){
                close++;
                p.insert(0 , ch);
            }else if(ch == '('){
                if(close > 0){
                    close--;
                    p.insert(0 , ch);
                }
            }else p.insert(0 , ch);
        }
        return p.toString();
    }
}
