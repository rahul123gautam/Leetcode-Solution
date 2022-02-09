Problem Link :- leetcode.com/problems/maximum-sum-circular-subarray/
  
  
  
  
   ************************CODE************************
   
  
  class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int maxSum1 = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(maxSum1 < sum){
                maxSum1 = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        sum = 0;
        int minSum = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(minSum > sum){
                minSum = sum;
            }
            if(sum > 0){
                sum = 0;
            }
        }
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum - minSum != 0){
            minSum = sum - minSum;
        }
        return minSum > maxSum1?minSum:maxSum1;
    }
}
