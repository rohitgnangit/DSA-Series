// Leetcode-268: Missing Number
// Level-Easy

// Input: nums = [3,0,1]
// Output: 2
// Explanation:
// n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

class Solution {
    public int missingNumber(int[] nums) {
         Arrays.sort(nums);
         int n = nums.length;
         int ans = 0;
         for(int i=0;i<n;i++){
           if(nums[i]!=i){
               return i;
           }
       }
       if(ans == 0){
        ans = nums.length;
       }
           return ans;
    }
}