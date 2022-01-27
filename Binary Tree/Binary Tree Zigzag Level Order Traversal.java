Problem Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/


                 ****************CODE****************
                 
                   
                   
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>que = new LinkedList<>();
        List<List<Integer>>ans = new LinkedList<>();
        boolean check = true;
        if(root == null){
            return ans;
        }
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer>list = new LinkedList<>();
            int len = que.size();
            for(int i = 0; i < len; i++){
                TreeNode temp = que.poll();
                if(check){
                    list.add(temp.val);
                }else{
                    list.add(0 , temp.val);
                }
                if(temp.left != null) que.offer(temp.left);
                if(temp.right != null) que.add(temp.right);
            }
            check = !check;
            ans.add(list);
        }
        return ans;
    }
}





