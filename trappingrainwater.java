//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
class Solution {
    public int trap(int[] height) {
        int l = 0;
        int n = height.length;
        int r = n-1;
        int lmax = 0;
        int total =0;
        int rmax = 0;
        while (l<r){
            if(height[l]<= height[r]){
                if(lmax > height[l]){
                    total += lmax-height[l];
                }
                else{
                    lmax = height[l];
                }
                l++;
            }
            else{
                if(rmax >= height[r]){
                    total += rmax - height[r];
                }
                else{
                    rmax = height[r];
                }
                r--;
            }
        }
        return total;
    }
}
