// Leetcode-81: Search in Rotated Sorted Array II
// Level-Medium

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true

// Same as Search in Rotated Sorted Array 1
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int breakPoint = n-1;
        int l = 0;
        int r = n - 1;
        while (n > 2 && r > 0 && l < n && nums[r-1] <= nums[r]) {
            r--;
            breakPoint = r;
        }
        
        int left = 0;
        int right = breakPoint - 1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return true;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < left) {
            int ll = breakPoint;
            int rr = n - 1;
            while (ll <= rr) {
                int mid = ll+(rr-ll)/2;
                if (nums[mid] == target) {
                    return true;
                } else if (target < nums[mid]) {
                    rr = mid - 1;
                } else {
                    ll = mid + 1;
                }
            }
            if (right < left) {
                return false;
            }
        }
        return false;
    }
}