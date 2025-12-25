// Leetcode-26: Remove Duplicates from Sorted Array
// Level-Easy

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        // First element in array always unique. so, start from index 1
        for (int i = 1; i < nums.length; i++) {
            // Compare the current index element with previous
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}