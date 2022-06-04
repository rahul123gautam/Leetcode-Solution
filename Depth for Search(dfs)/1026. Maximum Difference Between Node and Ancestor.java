Problem Link:- https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/





                 ************************CODE****************************
                 
                 
 class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        List<Integer>ancestorLeft = new ArrayList<>();
        List<Integer>ancestorRight = new ArrayList<>();
        ancestorLeft.add(root.val);
        ancestorRight.add(root.val);
        dfs(root.left , ancestorLeft);
        dfs(root.right , ancestorRight);
        return ans;
    }
    public void dfs(TreeNode root , List<Integer>ancestor){
        if(root == null) return;
        for(int i = 0; i < ancestor.size(); i++){
            ans = Math.max(ans , Math.abs(ancestor.get(i)-root.val));
        }
        ancestor.add(root.val);
        dfs(root.left , new ArrayList<>(ancestor));
        dfs(root.right ,  new ArrayList<>(ancestor));
    }
}
