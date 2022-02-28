Problem Link:- https://leetcode.com/problems/find-right-interval/



You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

 

Example 1:

Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:

Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
Example 3:

Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 

Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-106 <= starti <= endi <= 106
The start point of each interval is unique.
  
  
  
                *******************CODE******************
                
  
  class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        HashMap<Integer , Integer>map = new HashMap<>();
        int[]arr = new int[n];
        for(int i = 0; i < n; i++){
            map.put(intervals[i][0] , i);
            arr[i] = intervals[i][0];
        }
        Arrays.sort(arr);
        int[]ans = new int[n];
        for(int i = 0; i < n; i++){
            int key = intervals[i][1];
            if(key > arr[n-1]) {
                ans[i] = -1;
                continue;
            }
            int l = 0;
            int r = n-1;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(arr[mid] == key) {
                    ans[i] = map.get(key);
                    break;
                } else if(arr[mid] > key) {
                    if(mid - 1 < 0 || arr[mid-1] < key) {
                        ans[i] = map.get(arr[mid]);
                        break;
                    } else {
                        r = mid - 1;
                      }
                } else {
                    l = mid + 1;
                  }
            }
        }
        return ans;
    }
}
