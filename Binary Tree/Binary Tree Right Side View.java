Problem Link :- https://leetcode.com/problems/binary-tree-right-side-view/




                 *********************CODE***********************
                 
                   
                   
 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>list = new ArrayList<>();
        rightView(root , 0 , list);
        return list;
    }
    public void rightView(TreeNode root , int level , ArrayList<Integer>list){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        rightView(root.right , level + 1 , list);
        rightView(root.left , level + 1 , list);
    }
}
