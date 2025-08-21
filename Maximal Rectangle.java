/*Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.*/

class Solution {
    private int Histogram(int[] heights){
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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] psum = new int[n][m];
        for(int j=0;j<m;j++){
            int sum =0;
            for(int i =0; i<n;i++){
                sum += matrix[i][j];
                if (matrix[i][j] == '1') {
                    psum[i][j] = (i == 0 ? 1 : psum[i - 1][j] + 1);
                } else {
                    psum[i][j] = 0;
                }
            }
        }
        int maxArea =0;
        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea, Histogram(psum[i]));
        }
        return maxArea;
    }
}
