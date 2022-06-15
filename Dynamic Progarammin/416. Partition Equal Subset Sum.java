Problem Link:- https://leetcode.com/problems/partition-equal-subset-sum/submissions/



 *******************CODE********************
 
 class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0 , n = nums.length;
        for(int i=0; i<n; i++) sum += nums[i];
        if(sum%2!= 0) return false;
        int target = sum/2 ;
        int[][]dp = new int[n][target+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < target+1; j++){
                dp[i][j] = -1;
            }
        }
        return subsetSum(nums , 0 , n , target , dp);
    }
    public static boolean subsetSum(int[]arr , int i , int n , int target , int[][]dp){
        if(target == 0) return true;
        if(i == n-1) return (arr[i] == target);
        if(dp[i][target] != -1){
            if(dp[i][target] == 0) return false;
            else return true;
        }
        boolean not_take = subsetSum(arr , i+1 , n , target , dp);
        boolean take = false;
        if(arr[i] <= target) take = subsetSum(arr , i+1 , n , target - arr[i] , dp);
        boolean check = take | not_take;
        if(!check) dp[i][target] = 0;
        else dp[i][target] = 1;
        return take | not_take;
    }
}
