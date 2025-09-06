/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;
       int maxind =0;
       for(int i=0;i<n;i++){
        if(maxind<i) return false;
        int ind = nums[i] + i;
        maxind = Math.max(ind,maxind);
       } 
       if(maxind>=n-1) return true;
       return false;
    }
}
