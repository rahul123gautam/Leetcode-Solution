Problem Link:- https://leetcode.com/problems/add-one-row-to-tree/


               ******************CODE*****************
               
                 
                 
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val , root , null);
            return node;
        }
        Queue<TreeNode>que = new LinkedList<>();
        que.offer(root);
        int level = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode node = que.remove();
                if(level == depth - 1){
                    TreeNode left = new TreeNode(val , node.left , null);
                    TreeNode right = new TreeNode(val , null , node.right);
                    node.left = left;
                    node.right = right;
                }
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            if(level == depth - 1) break;
            level++;
        }
        return root;
    }
}
