// Leetcode-992: Subarrays with K Different Integers
// Level-Hard

// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

class Solution {
    public int atMost (int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            int key = nums[r];
            hm.put(key, hm.getOrDefault(key, 0)+1);
            while (hm.size() > k) {
                int leftKey = nums[l];
                hm.put(leftKey, hm.get(leftKey)-1);
                if (hm.get(leftKey) == 0) {
                    hm.remove(leftKey);
                }
                l++;
            }
            ans += r-l+1;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
       int finalAnswer = atMost(nums, k) - atMost(nums, k-1);
       return finalAnswer;
    }
}