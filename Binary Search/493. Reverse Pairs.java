Problem Link:- https://leetcode.com/problems/reverse-pairs/


Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
  
  
  
  
  
                            ***********************CODE*********************
                            
  class Solution {
    public int reversePairs(int[] nums) {
        int ans = 0 , n = nums.length;
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i = 0; i < n; i++){
            int start = 0 , end = list.size() -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[i]  == list.get(mid)){
                    list.remove(mid);
                    break;
                }else if(nums[i] < list.get(mid))end = mid - 1;
                else start = mid + 1;
            }
            start = 0; end = list.size() - 1;
            int val = 0;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[i] > (long)2*list.get(mid)){ // long for last 3 edgs cases.
                    if((mid + 1) > val) val = mid + 1;
                    start = mid + 1;
                }else end = mid - 1;
            }
            ans += val;
        }
        return ans;
    }
}
