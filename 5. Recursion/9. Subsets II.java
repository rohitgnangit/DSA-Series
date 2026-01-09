// -----Back Tracking-----
// Leetcode-90: Subsets II
// Level-Medium

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

class Solution {
    // Generate only unique subsets and add in list TC-[O(n*2^n)]
    public void getSubsets(int[] nums, int index, int n, List<List<Integer>> list, List<Integer> temp) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < n; i++) {
            if (i != index && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            getSubsets(nums, i+1, n, list, temp);
            temp.remove(temp.size()-1);
        }

    }
    // // Generate all subsets and add unique in list "TC-[O(n*4^n)]"
    // public void getSubsets(int[] nums, int i, int n, List<List<Integer>> list, List<Integer> temp) {
    //     if (i == n) {
    //         if(!list.contains(temp)) {
    //             list.add(new ArrayList<>(temp));
    //         }
    //         return;
    //     }
    //     temp.add(nums[i]);
    //     getSubsets(nums, i+1, n, list, temp);
    //     temp.remove(temp.size()-1);
    //     getSubsets(nums, i+1, n, list, temp);

    // }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        getSubsets(nums, i, n, list, temp);
        return list;
    }
}