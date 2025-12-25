// Leetcode-189: Rotate Array
// Level-Medium

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] duplicate = new int[n];
        int[] rotated = new int[n];
        k = k % n;
        
        for (int i = 0; i < n; i++) {
            duplicate[i] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            // The maths formula is must for rotating an Array
            nums[i] = duplicate[(i-k+n) % n];
        }
    }
}