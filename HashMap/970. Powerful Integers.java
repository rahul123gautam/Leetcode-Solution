Problem Link:- https://leetcode.com/problems/powerful-integers/


Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.

You may return the answer in any order. In your answer, each value should occur at most once.

 

Example 1:

Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 20 + 30
3 = 21 + 30
4 = 20 + 31
5 = 21 + 31
7 = 22 + 31
9 = 23 + 30
10 = 20 + 32
Example 2:

Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]
 

Constraints:

1 <= x, y <= 100
0 <= bound <= 106
  
  
                         ****************************************************************************************************************
                         **********************************************CODE**************************************************************
                         
  class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int boundX = 0, boundY = 0;
        int val = 0;
        List<Integer>list = new ArrayList<>();
        HashMap<Integer , Integer>map = new HashMap<>();
        if(x == 1) boundX = x;
        else  
            while(val < bound){
                val = (int)Math.pow(x , boundX++);
            }
        val = 0;
        if(y == 1) boundY = y;
        else 
            while(val < bound){
                val = (int)Math.pow(y , boundY++);
            }
        val = 0;
        for(int i = 0; i < boundX; i++){
            for(int j = 0; j < boundY; j++){
                val = (int)Math.pow(x , i) + (int)Math.pow(y , j);
                if(val <= bound) map.put(val , 0);
                else break;
            }
        }
        for(int value : map.keySet()){
            list.add(value);
        }
        return list;
    }
}
