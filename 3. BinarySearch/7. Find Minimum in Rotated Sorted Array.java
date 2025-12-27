// Leetcode-153: Find Minimum in Rotated Sorted Array
// Level-Medium

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if ((mid+1) < n && nums[mid+1] < nums[mid]) {
                return nums[mid+1];
            } else if ((mid-1) >=0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if (nums[mid] < nums[r]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            if (r == 0) {
                return nums[0];
            }
        }
        return nums[0];
    }
}