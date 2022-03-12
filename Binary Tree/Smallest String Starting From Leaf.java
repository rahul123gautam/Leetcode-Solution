problem Link:- https://leetcode.com/problems/smallest-string-starting-from-leaf/

You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

 

Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
 

Constraints:

The number of nodes in the tree is in the range [1, 8500].
0 <= Node.val <= 25
  
  
  
                                                         *************************************************************************
                                                         ************************************Code*********************************
                                                         
  
  class Solution {
    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        if(root.left == null && root.right == null){
            String p = "";
            p+= (char)(root.val + 97);
            return p;
        }
        char ch = (char)(root.val + 97);
        helper(root.left , "" + ch);
        helper(root.right , "" + ch);
        return ans;
    }
    public void helper(TreeNode root  , String up ){
        if(root == null) return;
        char ch = (char)(root.val + 97);
        if(root.left == null && root.right == null){
            up = ch + up;
            if(ans == "") ans = up;
            else{
                if(ans.compareTo(up) > 0) ans = up;
            }
            return;
        }
        helper(root.left , ch + up);
        helper(root.right , ch + up);
    }
}
