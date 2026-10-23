// Q : Find the nth Fibonacci number using tabulation. (Bottom-Up approach)
// This is same as memoization but we start from the base case and build the solution up to the required value.

class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}

// output:
// 5
