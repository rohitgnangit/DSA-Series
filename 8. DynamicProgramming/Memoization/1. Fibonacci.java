// Q : Find the nth Fibonacci number using memoization. (Top-Down approach)
// This is same as recursion but we skip the repeated calls by storing the results in an array and using it when needed.

import java.util.*;

class Main {
    public static int fibonacci(int n, int[] dp) {
        if(n <= 1) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
    }
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacci(n, dp));
    }
}

// Output:
// 5