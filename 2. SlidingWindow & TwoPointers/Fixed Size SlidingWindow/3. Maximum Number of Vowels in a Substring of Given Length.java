// Leetcode-1456: Maximum Number of Vowels in a Substring of Given Length
// Level-Medium

// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.

class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int ans = 0;
        int count = 0;
        int l = 0;
        for(int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            if (r - l == k) {
                char leftCh = s.charAt(l);
                 if (leftCh == 'a' || leftCh == 'e' || leftCh == 'i' || leftCh == 'o' || leftCh == 'u') {
                     count--;
                }
                l++;
            }
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}