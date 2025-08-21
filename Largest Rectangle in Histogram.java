/*Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> st = new Stack <>();
        int maxi = 0;
        
        for(int i =0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]> heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1: st.peek();
                maxi = Math.max(maxi, (heights[element]* (nse-pse-1)));
            }
            st.push(i);
        }
        while (!st.isEmpty()){
                int element = st.peek();
                int n = heights.length;
                st.pop();
                int nse = n;
                int pse = st.isEmpty()? -1: st.peek();
                maxi = Math.max(maxi,(heights[element]* (nse-pse-1)));
            
        }
        return maxi;
    }
}
