Problem Link:- https://leetcode.com/problems/find-largest-value-in-each-tree-row/



Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-231 <= Node.val <= 231 - 1
  
  
  
                                           **************************************************************************************
                                           *****************************************CODE*****************************************
                                           
  
  class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode>que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            int val = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                TreeNode temp = que.remove();
                if(temp.left != null) que.add(temp.left);
                if(temp.right != null) que.add(temp.right);
                if(val < temp.val) val = temp.val;
            }
            list.add(val);
        }
        return list;
    }
}
