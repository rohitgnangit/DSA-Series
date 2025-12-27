// Leetcode-35: Search Insert Position
// Level-Easy

// Input: nums = [1,3,5,6], target = 5
// Output: 2

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target>nums[mid]){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return l;
    }
}