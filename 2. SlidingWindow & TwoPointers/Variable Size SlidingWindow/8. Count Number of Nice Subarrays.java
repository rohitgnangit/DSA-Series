// Leetcode-1248: Count Number of Nice Subarrays
// Level-Medium

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// We should not count no of subarrays, we just add the all subarrays sizes which contains atmost k odd numbers.
class Solution {
    public int atMost (int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] % 2 != 0) {
                count++;
            }
            while (count > k) {
                if (nums[l] % 2 != 0) {
                    count--;
                }
                l++;
            }
            ans += r-l+1;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int finalAns = atMost(nums, k) - atMost(nums, k-1);
        return finalAns;
    }
}