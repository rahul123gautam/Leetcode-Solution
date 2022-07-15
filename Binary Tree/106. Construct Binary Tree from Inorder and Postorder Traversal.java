Problem link:- https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/



Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
  
  
  
  
                  ************************CODE***********************
                  
  
  
  
  class Solution {
    int postorderRoot = 0;
    Map<Integer , Integer> hsMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderRoot = postorder.length-1;
        hsMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hsMap.put(inorder[i] , i);
        }
        return arrayToTree(postorder , 0 , postorder.length-1);
    }
    public TreeNode arrayToTree(int[]postorder , int left , int right){
        if(left > right) return null;
        int rootValue = postorder[postorderRoot--];
        TreeNode root = new TreeNode(rootValue);
        root.right = arrayToTree(postorder , hsMap.get(rootValue)+1 , right);
        root.left = arrayToTree(postorder , left , hsMap.get(rootValue)-1);
        return root;
    }
}
