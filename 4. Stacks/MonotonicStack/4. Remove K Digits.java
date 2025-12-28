// Leetcode-402: Remove K Digits
// Level-Medium

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            int curr = num.charAt(i) - '0';
            while (!st.isEmpty() && curr < (st.peek() - '0') && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        // EdgeCase-1: if num = "123456"
        while (k > 0) {
            st.pop();
            k--;
        }
        // EdgeCase-2: 
        if (st.isEmpty()) {
            return "0";
        }
        Stack<Character> res = new Stack<>();
        while (!st.isEmpty()) {
            res.push(st.pop());
        }
        while (res.size() != 0 && res.peek() == '0') {
            res.pop();
        }
        String result = "";
        while (!res.isEmpty()) {
            result += res.pop();
        }
        // EdeCase-3:
        if (result == "") return "0";
        return result;
    }
}