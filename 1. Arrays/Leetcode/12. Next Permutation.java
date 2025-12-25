// Leetcode-31: Next Permutation
// Level-Medium

// Input: nums = [1,2,3]
// Output: [1,3,2]
// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap (nums, start++, end--);
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        // Finding the small number index compared to its right
        while (i > 0 && nums[i] <= nums[i-1]) i--;

        if (i > 0) {
            int j = n - 1;
            // Finding the big number index compared to previous small number
            while (nums[j] <= nums[i-1]) j--;
            swap (nums, i-1, j);
        }
        reverse(nums, i, n-1);
    }
}