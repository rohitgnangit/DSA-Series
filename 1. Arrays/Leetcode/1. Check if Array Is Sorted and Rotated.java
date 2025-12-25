// Leetcode-1752: Check if Array Is Sorted and Rotated
// Level-Easy

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].

class Solution {
    public boolean isSorted(int[] arr) {
        int count = 0;

        for(int i = 0;i < arr.length-1; i++) {
            if(arr[i] <= arr[i+1]) {
                count++;
            }
        }
        if(count == arr.length - 1) {
            return true;
        }
        return false;
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        int breakPoint = 0;
        int breakCount = 0;
        // Searching for break point to rotate
        for (int i = 0; i < n-1; i++) {
            if(!(nums[i] <= nums[i+1])) {
                breakPoint = i+1;
                breakCount++;
            }
        }
        // Rotating array using break point and storing into another array
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[(i+breakPoint) % n];
        }
        // Edge case
        if(breakCount > 1) {
            return false;
        }
        // Sending result array to isSorted function to check if the array was sorted or not
        return isSorted(sorted);
    }
}
