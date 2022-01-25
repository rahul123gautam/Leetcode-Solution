Problem Link: https://leetcode.com/problems/valid-mountain-array/


                            **********CODE**********
                            
                              
class Solution {
    public boolean validMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE , index = 0;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        if(index == 0 || index == arr.length - 1){
            return false;
        }
        for(int i = 1; i <= index; i++){
            if(arr[i] <= arr[i - 1]){
                return false;
            }
        }
        for(int i = index; i < arr.length - 1; i++){
            if(arr[i] <= arr[i + 1]){
                return false;
            }
        }
        return true;
    }
}                              
