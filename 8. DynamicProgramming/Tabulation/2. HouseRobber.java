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
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if(i > 1) pick += dp[i - 2];
            
            int notPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length - 1];
    }
}