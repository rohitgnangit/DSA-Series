// Leetcode-1: Two Sum
// Level-Easy

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
           int diff = target - nums[i];
           if(hm.containsKey(diff)){
               return new int[]{hm.get(diff),i};
           }else{
               hm.put(nums[i], i);
           }
        }
        return new int[]  {};
    }
}