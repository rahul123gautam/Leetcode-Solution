Problem Link:- https://leetcode.com/problems/find-k-th-smallest-pair-distance/



The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

 

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5
 

Constraints:

n == nums.length
2 <= n <= 104
0 <= nums[i] <= 106
1 <= k <= n * (n - 1) / 2
  
                               ***********************CODE**********************
                               
  class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0  , end = nums[n-1] - nums[0];
        while(start <= end){
            int mid = start + (end - start)/2;
            if(check(nums , mid) >= k){
                end = mid-1;
            }else start = mid + 1;
        }
        return start;
    }
    public int check(int[]nums , int mid){
        int total = 0 , left = 0, n = nums.length ;
        for(int right  = 0; right < n; right++){
            while(left < right && nums[right] - nums[left] > mid ) left++;
            total += right - left;
        }
        return total;
    }
}
