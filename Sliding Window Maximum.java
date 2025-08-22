/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList <Integer> al = new ArrayList<>();
        Deque <Integer> dq = new ArrayDeque<>();
        for(int i =0;i<=n-1;i++){
            while(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                al.add(nums[dq.peekFirst()]);
            }
        }
        int [] ans = new int [al.size()];
        for(int i =0 ; i<al.size();i++){
            ans[i] = al.get(i);
        }
        return ans;
    }
}
