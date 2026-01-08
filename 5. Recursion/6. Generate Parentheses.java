// Leetcode-22: Generate Parentheses
// Level-Medium

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

class Solution {
    public void generate(ArrayList<String> list, String s, int open, int close, int max) {
        if (s.length() == max*2) {
            list.add(s);
            return;
        }
        if (open < max) {
            generate(list, s+"(", open+1, close, max);
        }
        if (close < open) {
            generate(list, s+")", open, close+1, max);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String s = "";
        int open = 0;
        int close = 0;
        generate(list, s, open, close, n);
        return list;
    }
}