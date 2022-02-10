Problem Link:https://leetcode.com/problems/subarray-sums-divisible-by-k/




                    *******************CODE********************
                    
                      
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        HashMap<Integer , Integer>map = new HashMap<>();
        int sum = 0;
        map.put(0 , 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i]; 
            sum = sum%k;
            sum = sum<0?sum+k:sum;
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            if(map.containsKey(sum)) map.put(sum , map.get(sum) + 1);
            else map.put(sum , 1);
        }
        return count;
    }
}
