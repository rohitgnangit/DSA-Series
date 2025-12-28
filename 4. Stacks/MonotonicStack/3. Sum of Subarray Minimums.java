// Leetcode-907: Sum of Subarray Minimums
// Level-Medium

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.

class Solution {
    public int[] findNSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            nse[i] = st.isEmpty()? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public int[] findPSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            pse[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (long) right * left * arr[i]) % mod;
        }
        return (int)total;
    }
}