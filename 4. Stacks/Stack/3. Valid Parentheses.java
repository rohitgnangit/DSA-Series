// Leetcode-20: Valid Parentheses
// Level-Easy

// Input: s = "([])"
// Output: true

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (ch == ']') {
                    if (!st.isEmpty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (ch == '}') {
                    if (!st.isEmpty() && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}


// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> st = new Stack<>();
        
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(ch==')' || ch==']' || ch=='}'){
//                 if(st.isEmpty()){
//                     return false;
//                 }
//                 char top = st.pop();
//                 if(top=='('){
//                     if(ch != ')')
//                     return false;
//                 }
//                 if(top=='['){
//                     if(ch != ']')
//                     return false;
//                 }
//                 if(top=='{'){
//                     if(ch != '}')
//                     return false;
//                 }
//             }else {
//                 st.push(ch);
//             }
//         }
//         if(st.size() != 0){
//             return false;
//         }else {
//             return true;
//         }
//     }
// }