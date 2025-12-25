// Leetcode-3: Longest Substring Without Repeating Characters
// Level-Medium

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int n = s.length();
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            while (hm.containsKey(ch)) {
                char leftCh = s.charAt(l);
                hm.remove(leftCh);
                l++;
            }
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
            ans = Math.max(ans, hm.size());
        }
        return ans;

        //  HashSet<Character> hs = new HashSet<>();
        // int n = s.length();
        // int ans = 0;
        // int l = 0;
        // for(int r=0;r<n;r++){
        //     char ch = s.charAt(r);
        //    if(!hs.contains(ch)){
        //     hs.add(ch);
        //    }else{
        //     while(hs.contains(ch)){
        //         hs.remove(s.charAt(l));
        //     l++;
        //     }
        //     hs.add(ch);
        //    }
        //    ans = Math.max(ans, r-l+1);
        // }
        // return ans;
    }
}