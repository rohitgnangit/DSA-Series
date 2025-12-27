//  Leetcode-704: Binary Search
// Level-Easy

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target<nums[mid]){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
