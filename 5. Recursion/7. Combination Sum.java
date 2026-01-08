// Leetcode-39: Combination Sum
// Level-Medium

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

class Solution {
    public void helper(int[] candidates, int i, int sum, int n, int target, List<List<Integer>> list, List<Integer> temp) {
        if (i == n) {
            if(sum == target) {
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        if (sum + candidates[i] <= target) {
            temp.add(candidates[i]);
            sum += candidates[i];
            // Take
            helper(candidates, i, sum, n, target, list, temp);
            sum -= temp.get(temp.size()-1);
            temp.remove(temp.size()-1);
        }
        // Not take
        helper(candidates, i+1, sum, n, target, list, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n =  candidates.length;
        int i = 0;
        int sum = 0;
        helper(candidates, i, sum, n, target, list, temp);
        return list;
    }
}