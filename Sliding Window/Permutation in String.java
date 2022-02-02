Problem Link:-https://leetcode.com/problems/permutation-in-string/



                     ***********************CODE**********************
                     
                       
************************USING RECURSION*********************************

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<String>result = permutation("" , s1);
        for(String s:result){
            if(s2.contains(s)){
                return true;
            }
        }
        return false;
    }
    public List<String> permutation(String p , String up){
        if(up.isEmpty()){
            List<String>list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String>ans = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0 , i);
            String s = p.substring(i , p.length());
            ans.addAll(permutation(f + ch + s , up.substring(1)));
        }
        return ans;
      }
 }
 

*************************USING SLIDING WINDOW*******************************


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
