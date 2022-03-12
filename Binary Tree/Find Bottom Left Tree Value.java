Problem Link:- https://leetcode.com/problems/find-bottom-left-tree-value/


Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
  
  
                                                 *******************************************************************************
                                                 ***********************************CODE****************************************
                                                 
  
  class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>que = new LinkedList<>();
        que.add(root);
        int ans = 0;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = que.remove();
                if(temp.left != null) que.add(temp.left);
                if(temp.right != null) que.add(temp.right);
                if(i == 0) ans = temp.val;
            }
        }
        return ans;
    }
}
