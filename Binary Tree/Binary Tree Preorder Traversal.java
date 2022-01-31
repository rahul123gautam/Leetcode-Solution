Problem Link : https://leetcode.com/problems/binary-tree-preorder-traversal/


                                  ***************CODE****************
                                  
 **************************USING RECURSION****************************                                   
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        preorder(root , ans);
        return ans;
    }
    public void preorder(TreeNode root , List<Integer>ans){
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorder(root.left , ans);
        preorder(root.right , ans);
    }
  
  
}
  ********************ITRATIVE METHOD*********************
  
    
    
    
    class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
    //     preorder(root , ans);
    //     return ans;
    // }
    // public void preorder(TreeNode root , List<Integer>ans){
    //     if(root == null){
    //         return;
    //     }
    //     ans.add(root.val);
    //     preorder(root.left , ans);
    //     preorder(root.right , ans);
        
        Stack<TreeNode>st = new Stack<>();
        if(root == null){
            return ans;
        }
        st.add(root);
        while(!st.isEmpty()){
            root = st.pop();
            ans.add(root.val);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return ans;
    }
}

