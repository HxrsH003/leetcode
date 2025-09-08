/* 
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping. 

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
*/

class Pair{
    int start;
    int endt;
    public Pair(int _start, int _endt){
        this.start = _start;
        this.endt = _endt;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Pair[] arr = new Pair[intervals.length];
        if(intervals.length == 0) return 0;
        for(int i =0;i< intervals.length;i++){
            arr[i] = new Pair(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(arr,(a,b) -> a.endt-b.endt);
        int count =0;
        int freetime =arr[0].endt;
        for(int i=1;i<intervals.length;i++){
            if(arr[i].start < freetime){
                count++;
            }
            else{
                freetime = arr[i].endt;
            }
        }
        return count;
    }
}
