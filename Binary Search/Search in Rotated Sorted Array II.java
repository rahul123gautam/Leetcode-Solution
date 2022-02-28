Problem Link :- https://leetcode.com/problems/search-in-rotated-sorted-array-ii/


There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
  
  
  
                 *******************************************************************
                 ***********************CODE****************************************
                 
  
  class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                pivot = i-1;
                break;
            }
        }
        int start1 = 0;
        int end1 = pivot;
        while(start1 <= end1){
            int mid = start1 + (end1 - start1)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) end1 = mid -1;
            else start1 = mid + 1;
        }
        int start2 = pivot + 1;
        int end2 = nums.length-1;
        while(start2 <= end2){
            int mid = start2 + (end2 - start2)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) end2 = mid -1;
            else start2 = mid + 1;
        }
        return false;
    }
}
