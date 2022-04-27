                        
 Problem Link:- https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
  
                                                 *****************CODE**************
  
  
                          
 class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int start = 0 , end = list.size() -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[i]  == list.get(mid)){
                    list.remove(mid);
                    break;
                }else if(nums[i] < list.get(mid))end = mid - 1;
                else start = mid + 1;
            }
            start = 0; end = list.size() - 1;
            int val = 0;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[i] > list.get(mid)){
                    if((mid + 1) > val) val = mid + 1;
                    start = mid + 1;
                }else end = mid - 1;
            }
            ans.add(val);
        }
        return ans;
    }
}                         
