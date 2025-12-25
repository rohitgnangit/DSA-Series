// Leetcode-219: Contains Duplicate II
// Level-Easy

// Input: nums = [1,2,3,1], k = 3
// Output: true

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();

        int l = 0;
        if (k == 0) {
            return false;
        }
        for (int r = 0; r < nums.length; r++) {
           if (hs.contains(nums[r])) {
                return true;
           } else {
                hs.add(nums[r]);
           }
            if (r-l == k) {
                hs.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}