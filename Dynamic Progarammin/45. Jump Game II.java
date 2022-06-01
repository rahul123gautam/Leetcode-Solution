Problem Link:- https://leetcode.com/problems/jump-game-ii/


  ***********************CODE**************************
  
    
    class Solution {
    public int jump(int[] nums) {
        int current_jump = 0 , last_jump = 0 , count = 0;
        for(int i = 0; i < nums.length-1; i++){
            current_jump = Math.max(current_jump , i + nums[i]);
            if(i == last_jump){
                count++;
                last_jump = current_jump;
            }
        }
        return count;
    }
}
