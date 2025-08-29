/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
*/


class Solution {
    private int count1(int[] nums, int k){
        int l =0;
        int r=0;
        int n = nums.length;
        int count1 =0;
        int sum =0;  
        while(r<n){
            sum = sum+ nums[r];
            while(sum>k && l<=r){
                sum = sum - nums[l];
                l++;
            }
            count1 = count1+ (r-l+1);
            r=r+1;
        }
        return count1;         
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count1(nums,goal) - count1(nums,goal-1);
    }
}
