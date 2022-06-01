Problem Link:- https://leetcode.com/problems/jump-game/


 ************************CODE*************************
 
   class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
        for(int i = 0; i < nums.length; i++){
            if(reachable < i) return false;
            reachable = Math.max(reachable , nums[i] + i);
        }
        return true;
    }
}
