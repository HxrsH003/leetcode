/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
*/

import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack <>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
            st.push(s.charAt(i));
            else{
                if(st.isEmpty())return false;
            
            char ch = st.peek();
            if(s.charAt(i)==')' && ch == '(' || s.charAt(i)== '}' && ch == '{' || s.charAt(i)==']' && ch == '['){
                st.pop();
            }
            else{
                return false;
            }
            }
        }
        return st.empty();
    }
}
