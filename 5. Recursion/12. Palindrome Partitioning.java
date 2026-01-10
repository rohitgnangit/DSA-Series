// -----Back Tracking-----
// Leetcode-131: Palindrome Partitioning
// Level-Medium

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

class Solution {
    public boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
    public void getPalindromes(String s, int index, List<String> temp, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index+1; i <= s.length(); i++) {
            if (isPalindrome(s, index, i-1)) {
                temp.add(s.substring(index, i));
                getPalindromes(s, i, temp, res);
                temp.remove(temp.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int index = 0;
        getPalindromes(s, index, temp, res);
        return res;
    }
}