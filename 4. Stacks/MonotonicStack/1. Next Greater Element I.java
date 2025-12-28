// Leetcode-496: Next Greater Element I
// Level-Easy

// Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
// Explanation: The next greater element for each value of nums1 is as follows:
// - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
// - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
// - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

// First we have to find out all next greater elements for each element in nums2 and store into HashMap.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        // int[] nextGreater = new int[100000];

        for (int i = nums2.length-1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }
            // nextGreater[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            int key = nums2[i];
            if(st.isEmpty()) {
                hm.put(key, -1);
            } else {
                hm.put(key, st.peek());
            }
            st.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            // nums1[i] = nextGreater[nums1[i]];
            nums1[i] = hm.get(nums1[i]);
        }
        return nums1;
    }
}