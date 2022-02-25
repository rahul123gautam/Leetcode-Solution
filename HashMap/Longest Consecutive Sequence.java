Problem Link : //leetcode.com/problems/longest-consecutive-sequence/


Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
  
  
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
  
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
  
  
  
                       ****************CODE*******************
                       
  class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer , Boolean>map = new HashMap<>();
        for(int val : nums){
            map.put(val , true);
        }
        for(int val : nums){
            if(map.containsKey(val - 1)){
                map.put(val , false);
            }
        }
        int max = 0;
        for(int val : nums){
            if(map.get(val) == true){
                int idx = 1;
                while(map.containsKey(val + idx)){
                    idx++;
                }
                if(idx > max){
                    max = idx;
                }
            }
        }
        // sparsh kumar
        return max;
    }
}
