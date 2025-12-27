// Leetcode-33: Search in Rotated Sorted Array
// Level-Medium

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// 1. First findout the break point where the array unsorted.
// 2. Next first search the target element within the left side sorted array.
// 3. If the target element is not found in left array then search the target element within the right side sorted array.
// 4. If there is no target element in right array too then return -1;
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int breakPoint = 0;

        while ( r >= 0 && l < n && nums[l] > nums[r]) {
            breakPoint = r;
            r--;
        }

        int left = 0;
        int right = breakPoint - 1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == target) {
                return mid;
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
                    return mid;
                } else if (target < nums[mid]) {
                    rr = mid - 1;
                } else {
                    ll = mid + 1;
                }
            }
            if (rr < ll) {
                return -1;
            }
        }
        return -1;
    }
}
