// -----Back Tracking-----
// Leetcode-47: Permutations II
// Level-Medium

// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

// Example 1:
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]

class Solution {
    public void getPermutations(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            getPermutations(nums, used, temp, res);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        getPermutations(nums, used, temp, res);
        return res;
    }
}