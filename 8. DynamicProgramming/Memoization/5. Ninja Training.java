// ------ 2D DP + Memoization Approach ------
// 125. Ninja's training :

// A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.
// Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.

// Example 1:
// Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
// Output: 210

// Explanation:
// Day 1: fighting practice = 70
// Day 2: stealth training = 50
// Day 3: fighting practice = 90
// Total = 70 + 50 + 90 = 210
// This gives the optimal points.

class Solution {
    public int fun(int[][] mat, int day, int last, int[][] dp) {
        if(day == 0) {
            int max = 0;
            for(int task = 0; task <= 2; task++) {
                if(task != last) {
                    max = Math.max(max, mat[day][task]);
                }
            }
            return max;
        }

        if(dp[day][last] != -1) return dp[day][last];
        int max = 0;

        for(int task = 0; task <= 2; task++) {
            if(task != last) {
                int point = mat[day][task] + fun(mat, day - 1, task, dp);
                max = Math.max(max, point);
            }
        }
        return dp[day][last] = max;
    }
    public int ninjaTraining(int[][] matrix) {
        int[][] dp = new int[matrix.length][4];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = matrix.length - 1;
        int last = 3;
        return fun(matrix, n, last, dp);
    }
}