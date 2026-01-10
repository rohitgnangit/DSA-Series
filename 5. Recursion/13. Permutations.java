// -----Back Tracking-----
// Leetcode-46: Permutations
// Level-Medium

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    public void getPermutations(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            getPermutations(nums, temp, res);
            temp.remove(temp.size()-1);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getPermutations(nums, temp, res);
        return res;
    }
}