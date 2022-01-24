Problem Link : https://leetcode.com/problems/median-of-two-sorted-arrays/

                        **********CODE***********

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length; 
        int len2 = nums2.length;
        List<Integer>ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(nums1[i] <= nums2[j]){
                ans.add(nums1[i++]);
            }
           else{
                ans.add(nums2[j++]);
            }
        }
         while(i < len1){
            ans.add(nums1[i++]); 
         }
         while(j < len2){
            ans.add(nums2[j++]); 
         }
        int len = ans.size();
        if(len%2 == 0){
            double first = ans.get(len/2);
            double second = ans.get(len/2 - 1);
            return (double)((first + second)/2.0);
        }else
            return (double)(ans.get(len/2));
    }
}
