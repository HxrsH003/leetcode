/*Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444*/

class Solution{
    private int[] findNSE(int[] arr){
        int n= arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack <>();
        for(int i=n-1; i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()? n : st.peek();
            st.push(i);
        }
        return nse; 
    }
    private int[] findPSE(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st1.isEmpty() && arr[st1.peek()]> arr[i]){
                st1.pop();
            }
            pse[i] = st1.isEmpty()? -1 : st1.peek();
            st1.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        int mod = (int)(1e9+7);
        for(int i=0; i<n; i++){
            long left = i- pse[i];
            long right = nse[i] -i;
            total = (total + (left*right*arr[i])%mod)%mod;
        }
        return (int)total;
    }
}
