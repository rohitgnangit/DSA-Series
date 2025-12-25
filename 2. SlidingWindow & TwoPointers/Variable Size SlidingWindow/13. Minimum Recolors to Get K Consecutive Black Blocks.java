// Leetcode-2379: Minimum Recolors to Get K Consecutive Black Blocks
// Level-Easy

// Input: blocks = "WBBWWBBWBW", k = 7
// Output: 3
// Explanation:
// One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
// so that blocks = "BBBBBBBWBW". 
// It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
// Therefore, we return 3.

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int count = 0;
        int ans = Integer.MAX_VALUE;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (blocks.charAt(r) == 'W') {
                count++;
            }
            if (r - l == k) {
                if (blocks.charAt(l) == 'W') {
                    count--;
                }
                l++;
            }
            if (r-l+1 == k) {
                ans = Math.min(ans, count);
            }
        }
        return ans;
    }
}