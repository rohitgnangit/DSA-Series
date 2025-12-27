// Leetcode-34: Find First and Last Position of Element in Sorted Array
// Level-Medium

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

class Solution {
    public int leftMost(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target<=nums[mid]){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        if(l>=nums.length){
            return -1;
        }
        if(target != nums[l]){
            return -1;
        }
        return l;
    }

    public int rightMost(int[] nums, int target){
         int l = 0;
         int r = nums.length-1;
         while(l<=r){
            int mid = l+(r-l)/2;
            if(target>=nums[mid]){
                l = mid+1;
            }else {
                r = mid-1;
            }
         }
         if(r<0){
            return -1;
         }
         if(target != nums[r]){
            return -1;
         }
         return r;
    }

    public int[] searchRange(int[] nums, int target) {
        int left = leftMost(nums, target);
        int right = rightMost(nums, target);
        int ans[] = {left, right};
        return ans; 
    }
}
