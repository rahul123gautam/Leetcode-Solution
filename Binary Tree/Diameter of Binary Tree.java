Problem Link :- leetcode.com/problems/diameter-of-binary-tree/
  
  
  
  
                    *****************CODE*****************
                    
  
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maximum(root);
        return ans;
    }
    public int maximum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maximum(root.left);
        int right = maximum(root.right);
        ans = Math.max(ans , left + right);
        return 1 + Math.max(right ,left);
    }
}
