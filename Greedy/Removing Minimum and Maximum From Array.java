Problem link : https://leetcode.com/problems/removing-minimum-and-maximum-from-array/





                      ********************CODE********************
                      
                        
class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE , maxIndex = 0;
        int min = Integer.MAX_VALUE , minIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
            if(min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }
        int mn = Math.min(maxIndex , minIndex);
        int mx = Math.max(maxIndex , minIndex);
        int first = mn + (nums.length - mx) + 1, second = mx + 1 , third = nums.length - mn;
        int ans = Math.min(first , second);
        ans = Math.min(ans , third);
        return ans;
    }
}
