// Leetcode - 198 : House Robber
// Level: Medium

// Example 1:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.

// Example 2:
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.


class Solution {
    public int fun(int[] nums, int n, int[] dp) {
        if(n == 0) return nums[n];
        if(n < 1) return 0;
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + fun(nums, n-2, dp);
        int notPick = 0 + fun(nums, n-1, dp);
        return dp[n] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return fun(nums, nums.length-1, dp);
    }
}