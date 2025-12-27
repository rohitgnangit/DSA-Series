// Leetcode-410: Split Array Largest Sum
// Level-Hard

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

class Solution {
    public boolean isPossible(int[] nums, int k, int x) {
        int sum = 0;
        int kk = k - 1;

        for (int i = 0; i < nums.length; i++) {
            if (x < nums[i]) {
                return false;
            }
            if ((sum + nums[i]) > x) {
                kk -= 1;
                sum = 0;
            }
            sum += nums[i];
            if (kk < 0) {
                return false;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (isPossible(nums, k, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
       }
       return l;
    }
}