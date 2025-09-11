/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int i=0;i<n;i++){
            hash[nums[i]]=1;
        }
        for(int i=0;i<=n;i++){
            if(hash[i]==0){
                return i;
            }
        }
         return -1;   
    }
}
