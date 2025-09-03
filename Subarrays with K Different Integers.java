/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
*/
class Solution {
    private int count1(int[] nums, int k) {
        int l =0;
        int r =0;
        int n = nums.length;
        int count =0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(r<n){
            mpp.put(nums[r], mpp.getOrDefault(nums[r],0)+1);
            while(mpp.size()>k){
                mpp.put((nums[l]), mpp.get(nums[l])-1);
                if(mpp.get(nums[l])==0){
                    mpp.remove(nums[l]);
                    
                }
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count1(nums,k) - count1(nums,k-1);
    }
}
