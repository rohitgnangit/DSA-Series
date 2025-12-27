// Leetcode-540: Single Element in a Sorted Array
// Level-Medium

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int mid = l+(r-l)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    l = mid+2;
                }else {
                    r = mid;
                }
            }else 
            if(mid % 2 != 0){
                if(nums[mid] == nums[mid-1]){
                    l = mid+1;
                }else {
                    r = mid;
                }
            }
        }
        return nums[r];
    }
}
