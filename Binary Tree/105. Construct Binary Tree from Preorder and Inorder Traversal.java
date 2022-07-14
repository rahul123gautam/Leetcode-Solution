Problem Link:- https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/



Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
  
  
  
              *************************CODE**************************
              
  
  class Solution {
    int preorderRoot = 0;
    Map<Integer , Integer> hsMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hsMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hsMap.put(inorder[i] , i);
        }
        return arrayToTree(preorder , 0 , preorder.length-1);
    }
    public TreeNode arrayToTree(int[]preorder , int left , int right){
        if(left > right) return null;
        int rootValue = preorder[preorderRoot++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder , left , hsMap.get(rootValue)-1);
        root.right = arrayToTree(preorder , hsMap.get(rootValue)+1 , right);
        return root;
    }
}
