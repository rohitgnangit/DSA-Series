// Leetcode-503: Next Greater Element II
// Level-Medium

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int[] res = new int[nums.length];

        for (int i = nums.length-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        for (int i = nums.length-1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}