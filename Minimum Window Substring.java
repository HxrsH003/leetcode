/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/


class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minlen = Integer.MAX_VALUE;
        int Sind= -1;
        int l =0;
        int r=0;
        int count =0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(int i =0; i<m;i++){
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i),0)+1);
        }
            while(r<n){
                if(mpp.getOrDefault(s.charAt(r),0)>0) count++;
                mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r),0)-1);
                while(count ==m){
                    if(minlen>r-l+1){
                        minlen = r-l+1;
                        Sind= l; 
                    }
                    mpp.put(s.charAt(l), mpp.getOrDefault(s.charAt(l),0)+1);
                    if(mpp.get(s.charAt(l))>0){
                        count--;
                    }
                    l++;
                    
                }
                r++;
            }
            
        if(minlen == Integer.MAX_VALUE) return "";
        return s.substring(Sind,Sind+minlen);
    }
}
