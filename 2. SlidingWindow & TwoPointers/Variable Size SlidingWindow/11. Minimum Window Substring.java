// Leetcode-76: Minimum Window Substring
// Level-Hard

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();

        if (s.length() < t.length()) {
            return "";
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char rightCh = s.charAt(r);
            if (hm.containsKey(rightCh)) {
                hm.put(rightCh, hm.get(rightCh)-1);
                if (hm.get(rightCh) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (r-l+1 < minLen) {
                    minLeft = l;
                    minLen = r-l+1;
                }
                char leftCh = s.charAt(l);
                if (hm.containsKey(leftCh)) {
                    hm.put(leftCh, hm.get(leftCh)+1);
                    if (hm.get(leftCh) > 0) {
                        count--;
                    }
                }
                l++;
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft+minLen);
    }
}