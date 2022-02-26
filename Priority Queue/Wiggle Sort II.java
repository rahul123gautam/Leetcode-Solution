Problem Link :- https://leetcode.com/problems/wiggle-sort-ii/




Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

You may assume the input array always has a valid answer.

 

Example 1:

Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.
Example 2:

Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
0 <= nums[i] <= 5000
It is guaranteed that there will be an answer for the given input nums.
 

Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
  
  
  
                ****************CODE****************
                
  
  class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = nums.length/2;
        for(int i = 0;i < nums.length; i++){
            pq.add(nums[i]);
        }
        List<Integer>list1 = new ArrayList<>();
         List<Integer>list2 = new ArrayList<>();
        while(index > 0){
            list1.add(pq.remove());
            index--;
        }
         while(!pq.isEmpty()){
            list2.add(pq.remove());
        }
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(i%2 == 0) nums[i] = list2.get(idx2++);
            else nums[i] = list1.get(idx1++);
        }
    }
}
