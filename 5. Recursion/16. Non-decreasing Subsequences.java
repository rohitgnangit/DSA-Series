// -----Back Tracking-----
// Leetcode-491: Non-decreasing Subsequences
// Level-Medium

// Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

// Example 1:
// Input: nums = [4,6,7,7]
// Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

class Solution {
    public void getSubsequences(int[] nums, int index, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.get(temp.size()-1)) continue;
            if (used.contains(nums[i])) continue;
            used.add(nums[i]);
            temp.add(nums[i]);
            getSubsequences(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        getSubsequences(nums, index, temp, res);
        return res;
    }
}