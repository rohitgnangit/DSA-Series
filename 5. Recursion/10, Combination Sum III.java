// -----Back Tracking-----
// Leetcode-216: Combination Sum III
// Level-Medium

// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
// Only numbers 1 through 9 are used.
// Each number is used at most once.
// Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

// Example 1:
// Input: k = 3, n = 7
// Output: [[1,2,4]]
// Explanation:
// 1 + 2 + 4 = 7
// There are no other valid combinations.

class Solution {
    public void getCombinations(int[] nums, int i, int size, int sum, int tempSum, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == size || i == nums.length) {
            if (tempSum == sum && temp.size() == size) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[i]);
        tempSum += nums[i];
        getCombinations(nums, i+1, size, sum, tempSum, temp, res);
        tempSum -= temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        getCombinations(nums, i+1, size, sum, tempSum, temp, res);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int i = 0;
        int tempSum = 0;
        getCombinations(nums, i, k, n, tempSum, temp, res);
        return res;
    }
}