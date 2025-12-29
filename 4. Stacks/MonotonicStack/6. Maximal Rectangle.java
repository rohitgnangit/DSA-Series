// Leetcode-85: Maximal Rectangle
// Level-Hard

// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.

// Must solve "Largest rectangle in a histogram" in optimal way before this problem
class Solution {
    // Logic to get Largest Histogram
    public int largestHistogram(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int elem = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max((heights[elem]*(nse-pse-1)), maxArea);
            }
            st.push(i);
        }
        // Stack cleanup
        while (!st.isEmpty()) {
            int elem = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max((heights[elem]*(nse-pse-1)), maxArea);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;  // Rows
        int m = matrix[0].length;  // Columns
        // Creating prefixSum matrix
        int[][] prefixSum = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = Character.getNumericValue(matrix[i][j]);
                sum += num;
                if (num == 0) {
                    sum = 0;
                }
                prefixSum[i][j] = sum;
            }
        }
        int maxArea = 0;
        // Sending each row of prefixSum matrix to largestHistogram function to get the maxArea
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestHistogram(prefixSum[i]));
        }
        return maxArea;
    }
}