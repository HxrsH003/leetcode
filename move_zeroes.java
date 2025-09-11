/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

 
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

class Solution {
    private void Swap(int i , int j,int[] nums){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j =-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            System.out.print(Arrays.toString(nums));
            return;
        }
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                Swap(i,j,nums);
                j++;
            }
        }
        System.out.print(Arrays.toString(nums));
    }
}
