// -----Back Tracking-----
// Leetcode-77: Combinations
// Level-Medium

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.

// Example 1:
// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

class Solution {
    public void getCombinations(int[] nums, int i, int size, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i == nums.length) return;
        temp.add(nums[i]);
        getCombinations(nums, i+1, size, temp, res);
        temp.remove(temp.size()-1);
        getCombinations(nums, i+1, size, temp, res);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int i = 0;
        getCombinations(nums, i, k, temp, res);
        return res;
    }
}