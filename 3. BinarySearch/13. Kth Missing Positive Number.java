// Leetcode-1539: Kth Missing Positive Number
// Level-Easy

// Input: arr = [2,3,4,7,11], k = 5
// Output: 9
// Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

class Solution {
    public int findKthPositive(int[] arr, int k) {
      for (int i : arr) {
        if (i <= k) {
            k++;
        } else {
            break;
        }
      }
      return k;
    }
}