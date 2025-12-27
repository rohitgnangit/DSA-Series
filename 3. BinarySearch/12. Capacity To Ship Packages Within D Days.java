// Leetcode-1011: Capacity To Ship Packages Within D Days
// Level-Medium

// Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
// Output: 15
// Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

class Solution {
    public boolean isPossible(int[] weights, int days, int capacity) {
        int temp = 0;
        int d = days - 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) return false;
            if (temp+weights[i] > capacity) {
                d -= 1;
                temp = 0;
            }
            temp += weights[i];
        }
        if (d >= 0) {
            return true;
        }
        return false;
        
        // int temp = 0;
        //  for(int i=0;i<weights.length;i++){
        //     int val = weights[i];
        //     if(val > k){
        //         return false;
        //     }
        //     if(temp+val > k){
        //         days -= 1;
        //         temp = 0;
        //     }
        //     temp += val;
        //     if(days == 0){
        //         return false;
        //     }
        //  }
        //  return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (isPossible(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
