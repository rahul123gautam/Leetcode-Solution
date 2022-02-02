  Problem Link:-https://leetcode.com/problems/find-all-anagrams-in-a-string/




                   *************************CODE**************************
                   
                     
                     
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       p = sortString(p);
       int left = 0;
       int right = p.length()-1;

       List<Integer> ans = new ArrayList();
       if(s.length() < p.length()){
           return ans;
       }
       while(right < s.length()){

             String current = sortString(s.substring(left, right+1));
             if (current.equals(p)){
                  ans.add(left);
                  while (right < s.length()-1 && s.charAt(right+1) ==  s.charAt(left)){
                         ans.add(left+1);
                         left++;
                         right++;
                  }
              }

              left++;
              right++;
         }

         return ans;

}

public String sortString(String s1) {

    char[] c = s1.toCharArray();
    Arrays.sort(c);

    return new String(c); 
    }
}
