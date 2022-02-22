Problem Link :- https://leetcode.com/problems/letter-tile-possibilities/


You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
  
  
                     *******************CODE*****************
                     
  
  class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[]check = new boolean[tiles.length()];
        Arrays.fill(check , false);
        Set<String>allPossi = new HashSet<>();
        findAllPossi("" , tiles , allPossi , check);
        return allPossi.size()-1;
    }
    public void findAllPossi(String p , String tiles , Set<String>allPossi , boolean[]check){
        if(p.length() > tiles.length()){
            return;
        }
        allPossi.add(p);
        for(int i = 0; i < tiles.length(); i++){
            if(!check[i]){
                check[i] = true;
                findAllPossi(p + tiles.charAt(i) , tiles , allPossi , check);
                check[i] = false;
            }
        }
    }
}
