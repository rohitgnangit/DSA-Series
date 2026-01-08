// Leetcode-40: Combination Sum II
// Level-Medium

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

class Solution {
    public void getCombinations(int[] candidates, int i, int target, int n,  List<List<Integer>> list, List<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int index = i; index < n; index++) {
            if (index > i && candidates[index] == candidates[index-1]) continue;
            if (candidates[index] > target) break;
            temp.add(candidates[index]);
            getCombinations(candidates, index+1, target-candidates[index], n, list, temp);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        int n = candidates.length;
        int i = 0;
        getCombinations(candidates, i, target, n, list, temp);
        return list;
    }
}