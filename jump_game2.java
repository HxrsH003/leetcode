/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l =0;
        int r =0;
        int jumps =0;
        while(r<n-1){
            int farthest =0;
            for(int i =l;i<=r;i++){
                farthest = Math.max(nums[i]+i,farthest);
            }
            l=r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
