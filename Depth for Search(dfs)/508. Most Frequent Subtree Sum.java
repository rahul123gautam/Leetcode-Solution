Problem Link:- https://leetcode.com/problems/most-frequent-subtree-sum/
  
  
  
  Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

 

Example 1:


Input: root = [5,2,-3]
Output: [2,-3,4]
Example 2:


Input: root = [5,2,-5]
Output: [2]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
  
  
                             ********************CODE*********************
                             
  
  
  class Solution {
    private int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer , Integer>map = new HashMap<>();
        dfs(root , map);
        ArrayList<Integer>list = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == max) list.add(i);
        }
        int[]ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public int dfs(TreeNode root , HashMap<Integer , Integer>map){
        if(root == null) return 0;
        int sum = root.val;
        sum += dfs(root.left , map);
        sum += dfs(root.right , map);
        map.put(sum , map.getOrDefault(sum , 0)+1);
        max = Math.max(max , map.get(sum));
        return sum;
    }
}
