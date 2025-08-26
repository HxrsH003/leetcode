/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l =0;
        int r =0;
        int maxlen = 0;
        HashMap<Character,Integer> mpp = new HashMap<>();
        while(r<n){
            if(mpp.containsKey(s.charAt(r)) && mpp.get(s.charAt(r)) != -1){
                if(mpp.get(s.charAt(r))>=l){
                    l = mpp.get(s.charAt(r))+1;
                }
            }
            int len = r-l+1;
            maxlen = Math.max(len,maxlen);
            mpp.put(s.charAt(r),r);
            r++;
        }
        return maxlen;

    }
}
