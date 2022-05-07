Problem Link:- https://leetcode.com/problems/deepest-leaves-sum/



Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
  
  
  
  
                                  ******************CODE******************
                                  
  
  
  class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode>q = new LinkedList<>();
        if(root == null) return 0;
        int ans = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int val = 0;
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                val += temp.val;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            ans = val;
        }
        return ans;
    }
}
