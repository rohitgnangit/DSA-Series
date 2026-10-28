// Leetcode-70: Climbing Stairs
// Level-Easy

// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Example 2:
// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step



// 1. We start from nth step and eventually comes to 0th step
// 2. we have to findout all combinations of the steps

class Solution {
    public int rec(int n, int[] dp) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        int first = rec(n - 1, dp);
        int second = rec(n - 2, dp);
        return dp[n] = first + second;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }
}