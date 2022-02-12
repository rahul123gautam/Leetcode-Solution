Problem Link:https://leetcode.com/problems/k-radius-subarray-averages/




                ********************CODE**********************
                
                  
                  
class Solution {
    public int[] getAverages(int[] nums, int k) {
        long  first = 0, second = 0;
        int n = nums.length;
        int[]arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = -1;
        }
        if(k >= n || 2*k >= n){
            return arr;
        }
        for(int i = 0; i < k; i++){
            first += nums[i];
        }
        for(int i = k + 1; i <= 2*k; i++){
            second += nums[i];
        }
        for(int i = k; i < n - k; i++){
            if(i != k){
                first = first + nums[i - 1] - nums[i - k - 1];
                second = second + nums[i + k] - nums[i];
            }
            arr[i] = (int)((first + second + nums[i])/(2*k + 1));
        }
        return arr;
    }
} 
