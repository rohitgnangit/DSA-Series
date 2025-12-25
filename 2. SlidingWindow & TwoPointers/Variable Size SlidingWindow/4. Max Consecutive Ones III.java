// Leetcode-1004: Max Consecutive Ones III
// Level-Medium

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

class Solution {
    public int longestOnes(int[] nums, int k) {
        // we dont need to flip 0's. we just need a max size subarray with k 0's.
        int n = nums.length;
        int count = 0;
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] == 0) {
                    count--;
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}