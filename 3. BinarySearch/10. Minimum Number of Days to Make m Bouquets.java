// Leetcode-1482: Minimum Number of Days to Make m Bouquets
// Level-Medium

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

class Solution {
    public boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int took = 0;

        for (int i = 0;i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                took++;
            } else {
                took = 0;
            }
            if (took == k) {
                took = 0;
                m--;
            }
            if (m == 0) {
                return true;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1;
        int r = (int)Math.pow(10, 9);
        int exceed = (int)Math.pow(10, 9);

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (isPossible(bloomDay, m, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l == exceed+1) {
            return -1;
        }
        return l;
    }
}
