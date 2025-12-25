// Leetcode-930: Binary Subarrays With Sum
// Level-Medium

// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

// You should not count sub arrays, you should add the all sub array sizes which contains at most goal sum
class Solution {
    public int atMost (int[] nums, int goal) {
        int n = nums.length;
        int ans = 0;
        int count = 0;
        int l = 0;
        if (goal < 0) {
            return 0;
        }
        for (int r = 0; r < n; r++) {
            if (nums[r] == 1) {
                count++;
            }
            while (count > goal) {
                if (nums[l] == 1) {
                    count--;
                }
                l++;
            }
            ans += r-l+1;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = atMost(nums, goal) - atMost(nums, goal-1);
        return ans;
    }
}