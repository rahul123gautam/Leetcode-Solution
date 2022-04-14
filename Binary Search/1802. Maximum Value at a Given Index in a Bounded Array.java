Problem Link:- https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/


You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.

 

Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].
Example 2:

Input: n = 6, index = 1,  maxSum = 10
Output: 3
 

Constraints:

1 <= n <= maxSum <= 109
0 <= index < n


                                          *************************************CODE***********************************
                                          
  
  class Solution {
    public int maxValue(int n, int index, int maxSum ) {
        int start = 1, end = maxSum , ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(isPossible(mid , index , maxSum , n)){
                ans = mid;
                start = mid + 1;
            }else end = mid - 1;
        }
        return ans;
    }
    public boolean isPossible(int mid , int index ,int maxSum , int n){
        mid--;
        long sum = -mid;
        long left = Math.min(index + 1, mid);
        long right = Math.min(mid ,n - index);
        sum += (left*(2*mid - left + 1)/2) + right*(2*mid - right + 1)/2;
        sum += n;
        return sum <= maxSum;
    }
}
