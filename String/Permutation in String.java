Program Link :- https://leetcode.com/problems/permutation-in-string/


          *****************CODE****************
          
            
 class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sortString(s1);
        int left = 0;
        int right = s1.length() - 1;
        if(s2.length() < s1.length()){
            return false;
        }
        while(right < s2.length()){
            String current = sortString(s2.substring(left , right + 1));
            if(current.equals(s1)){
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
    public String sortString(String s){
        char[]cr = s.toCharArray();
        Arrays.sort(cr);
        return new String(cr);
    }
}
