Problem Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/




                                  **********CODE**********
                                  
                                    
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, count = 1, cur = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == cur) {
                count++;  
            } else {
                count = 1;
                cur = nums[j];
            }
            if (count <= 2) {   
                i++;
                nums[i] = nums[j];
            }
        }
        
        return i + 1;
    }
}                                    
