/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
*/

class Solution {
    private int count(int[] nums, int k){
        int l =0;
        int r =0;
        int n = nums.length;
        int count =0;
        int sum =0;
        while (r<n){
            sum = sum + (nums[r]%2);
            while (sum>k){
                sum = sum - (nums[l] % 2);
                l++;
            }
            count= count + (r-l+1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return count(nums,k)- count(nums,k-1);
    }
}
