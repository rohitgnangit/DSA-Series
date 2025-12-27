// Leetcode-1283: Find the Smallest Divisor Given a Threshold
// Level-Medium

// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

class Solution {
    public boolean isPossible(int[] nums, int threshold, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]/k;
            if (nums[i]%k != 0) {
                sum++;
            }
        }
        if (sum <= threshold) {
            return true;
        }
        return false;
    }
    //  for(int i=0;i<nums.length;i++){
    //         threshold -= (int)Math.ceil((float)nums[i]/k);
    //     }
    //     if(threshold<0){
    //         return false;
    //     }
    //     return true;
    // }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = (int)Math.pow(10, 6);

        while (l <= r) {
            int mid = l + (r - l)/2;
            if (isPossible(nums, threshold, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
