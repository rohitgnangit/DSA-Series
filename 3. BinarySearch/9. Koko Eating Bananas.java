// Leetcode-875: Koko Eating Bananas
// Level-Medium

// Input: piles = [3,6,7,11], h = 8
// Output: 4

class Solution {
    public boolean isPossible (int[] piles, int h, int mid) {
    
        for (int i = 0; i < piles.length; i++) {
            int temp = piles[i]/mid;
            if (piles[i]%mid != 0) {
                temp++;
            }
            h -= temp;
        }
        if (h < 0) {
            return false;
        }
        return true;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = (int)Math.pow(10, 9);

        while (l <= r) {
            int mid = l + (r- l)/2;
            if (isPossible(piles, h, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
