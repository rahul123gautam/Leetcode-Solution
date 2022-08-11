Problem Link:- https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/



You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.

 

Example 1:


Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:


Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
 

Constraints:

1 <= n <= 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated edges.
  
  
  
                      ************************CODE***********************
                      
  
  
  class Solution {
    boolean[]visit;
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>>adjList = buildList(n , edges);
        visit = new boolean[n];
        List<Integer>ansList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                int cnt = 1 + dfs(i, adjList);
                ansList.add(cnt);
            }
        }
        long ans = 0,sum = n;
        for(int i = 0; i < ansList.size(); i++){
            sum -= ansList.get(i);
            ans += (ansList.get(i)*sum);
        }
        return ans;
    }
    public int dfs(int ind , List<List<Integer>>adjList){
        int ans = 0;
        List<Integer>list = adjList.get(ind);
        for(int i = 0; i < list.size(); i++){
            if(!visit[list.get(i)]){
                visit[list.get(i)] = true;
                ans += 1 + dfs(list.get(i), adjList);
            }
        }
        return ans;
    }
    public List<List<Integer>> buildList(int n , int[][]arr){
        List<List<Integer>>list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            list.get(arr[i][0]).add(arr[i][1]);
            list.get(arr[i][1]).add(arr[i][0]);
        }
        return list;
    }
}
