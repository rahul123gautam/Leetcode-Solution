Prooblem Link:- https://leetcode.com/problems/integer-replacement/


Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.

 

Example 1:

Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
Example 2:

Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
Example 3:

Input: n = 4
Output: 2
 

Constraints:

1 <= n <= 231 - 1
  
  
           *******************************CODE********************************
           
  
  class Solution {
    public HashMap<Long , Integer>map = new HashMap<>();
    public int integerReplacement(int n) {
        return minOperation((long)n);
    }
    public int minOperation(long n){
        if(n == 1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int operation = 0;
        if(n%2 == 0){
            operation = 1 + minOperation(n/2);
        }else {
            operation = 1 + Math.min(minOperation(n+1) , minOperation(n-1));
        }
        map.put(n , operation);
        return map.get(n);
    }
}
