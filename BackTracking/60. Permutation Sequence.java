Problem Link:- https://leetcode.com/problems/permutation-sequence/



The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
  
  
  
                           **********************CODE***********************
                           
  
  
  class Solution {
    private List<List<Integer>>ans = new ArrayList<>();
    public String getPermutation(int n, int k) {
        int[]nums1 = new int[n];
        for(int i = 0; i < n; i++){
            nums1[i] = i + 1;
        }
        boolean[]arr = new boolean[nums1.length];
        permutation(nums1 , new ArrayList<>() , arr , k);
        String s = "";
        List<Integer>list = ans.get(k-1);
        for(int i = 0; i < list.size(); i++){
            s += list.get(i);
        }
        return  s;
    }
    
    
    public void permutation(int[]nums , List<Integer>current, boolean[]arr , int k){
        if(ans.size() == k) return;
        if(current.size() == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!arr[i]){
                arr[i] = true;
                current.add(nums[i]);
                permutation(nums , current , arr , k);
                current.remove(current.size() - 1);
                arr[i] = false;
            }
        }
    }
}
