Problem Link:- https://leetcode.com/problems/permutations-ii/




Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
  
  
  
  
  
  
                             **************************CODE***************************
                             
  
  
  class Solution {
    private Set<List<Integer>>list = new HashSet<>();
    boolean[]taken;
    public List<List<Integer>> permuteUnique(int[] nums) {
        taken = new boolean[nums.length];
        makePermutation(nums ,  new ArrayList<>());
        List<List<Integer>>ans = new ArrayList<>();
        for(List<Integer>li : list){
            ans.add(li);
        }
        return ans;
    }
    public void makePermutation(int[]nums , List<Integer>current ){
        if(current.size() == nums.length){
            list.add(current);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!taken[i]){
                taken[i] = true;
                current.add(nums[i]);
                makePermutation(nums , new ArrayList<>(current));
                current.remove(current.size()-1);
                taken[i] = false;
            }
        }
    }
}
