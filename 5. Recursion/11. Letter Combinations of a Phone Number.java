// -----Back Tracking-----
// Leetcode-17: Letter Combinations of a Phone Number
// Level-Medium

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// image is there

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Accessing char in digits using index, and accessing char in "string of digit" is using i.
class Solution {
    private List<String> res = new ArrayList<>();
    private HashMap<Character, String> hm = new HashMap<>();

    public void getCombinations(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String s = hm.get(digit);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            getCombinations(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        int index = 0;
        StringBuilder sb = new StringBuilder();
        getCombinations(digits, index, sb);
        return res;
    }
}