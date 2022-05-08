Problem Link:- https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/



Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

 

Example 1:


Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
Example 2:

Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
  
  
                                *****************************CODE****************************
                                
  
  
  class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        int level = 0;
        int finalVal = Integer.MIN_VALUE;
        int ans = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int val = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.remove();
                val += temp.val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            if(val > finalVal){
                finalVal = val;
                ans = level;
            }
        }
        return ans;
    }
}
