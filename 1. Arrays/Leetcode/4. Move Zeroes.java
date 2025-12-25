// Leetcode-283: Move Zeroes
// Level-Easy

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

class Solution {
    public void moveZeroes(int[] nums) {
      int j = 0;

      for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            // Temp always stores Zeroes.
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
      }
    }
}