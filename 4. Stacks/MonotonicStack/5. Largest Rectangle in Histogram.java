// Leetcode-84: Largest Rectangle in Histogram
// Level-Hard

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

class Solution {
    public int[] NSE(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] PSE(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nse = NSE(heights);
        int[] pse = PSE(heights);
        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            largestArea = Math.max(largestArea, area);
        }
        return largestArea;
    }
}