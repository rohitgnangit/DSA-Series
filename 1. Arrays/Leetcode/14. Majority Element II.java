// Leetcode-229: Majority Element II
// Level-Medium

// Input: nums = [3,2,3]
// Output: [3]

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> arl = new ArrayList<>();
        
        int n = nums.length;
        int benchMark = n/3;

        for(int i = 0;i < n; i++) {
            int key = nums[i];
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }

        for(int ans: hm.keySet()) {
            if (hm.get(ans) > benchMark) {
                arl.add(ans);
            }
        }
        return arl;
    }
}