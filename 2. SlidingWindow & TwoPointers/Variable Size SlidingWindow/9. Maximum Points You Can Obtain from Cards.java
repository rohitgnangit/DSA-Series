// Leetcode-1423: Maximum Points You Can Obtain from Cards
// Level-Medium

// Input: cardPoints = [1,2,3,4,5,6,1], k = 3
// Output: 12
// Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

// We should find out totalsum of an array and then subtract totalsum from your subarray sum and that subtracted value is your answer. the subtractable subarray size is (n-k)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }
        int ans = 0;
        int currSum = 0;
        int kk = n-k;
        for (int r = 0; r < n; r++) {
            currSum += cardPoints[r];
            if (r - l == kk) {
                currSum -= cardPoints[l];
                l++;
            }
            if (r-l+1 == kk) {
                ans = Math.max(ans, (totalSum - currSum));
            }
        }
        return ans;
    }
}