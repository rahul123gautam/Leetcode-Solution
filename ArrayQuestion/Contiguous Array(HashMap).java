Problem Link :- https://leetcode.com/problems/contiguous-array/


                     ********************CODE*******************
                     
                       
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int longest_subArray = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i] == 0?-1:1;
            if(sum == 0){
                if(longest_subArray < i + 1){
                    longest_subArray = i + 1;
                }
            }else if(map.containsKey(sum)){
                    int length = i - map.get(sum);
                    longest_subArray = length > longest_subArray?length:longest_subArray;
            }else{
                map.put(sum , i);
            }
        }
        return longest_subArray;
    }
}
