// Leetcode-50: Pow(x, n)
// Level-Medium

// Input: x = 2.00000, n = 10
// Output: 1024.00000

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1/myPow(x, -(n + 1))/x;
        }
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}