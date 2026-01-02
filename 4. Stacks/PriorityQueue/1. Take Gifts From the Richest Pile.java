// Leetcode-2558: Take Gifts From the Richest Pile
// Level-Easy

// Input: gifts = [25,64,9,4,100], k = 4
// Output: 29
// Explanation: 
// The gifts are taken in the following way:
// - In the first second, the last pile is chosen and 10 gifts are left behind.
// - Then the second pile is chosen and 8 gifts are left behind.
// - After that the first pile is chosen and 5 gifts are left behind.
// - Finally, the last pile is chosen again and 3 gifts are left behind.
// The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < gifts.length; i++) {
            pq.add(gifts[i]);
        }
        while (k != 0) {
            int num = (int)Math.floor(Math.sqrt(pq.poll()));
            pq.add(num);
            k--;
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}