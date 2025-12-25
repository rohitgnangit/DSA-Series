// Leetcode-169: Majority Element
// Level-Easy

// Input: nums = [3,2,3]
// Output: 3

import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
       int n = nums.length;
       int ans = nums[n/2];
       return ans;
    }
}