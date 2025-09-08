/* 
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
*/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i =0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res.add(new int[]{intervals[i][0],intervals[i][1]});
            i = i+1;

        }
        while(i<intervals.length && intervals[i][0]<= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
            i=i+1;
        }
        res.add(new int[]{newInterval[0], newInterval[1]});
        while(i<intervals.length){
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i=i+1;
        }
        return res.toArray(new int[res.size()][]);
    }
}
