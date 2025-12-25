// Leetcode-121: Best Time to Buy and Sell Stock
// Level-Easy

// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int low = prices[0];
        for(int i=1;i<n;i++){
           int temp = prices[i]-low;
           profit = Math.max(profit, temp);
           if(prices[i] < low){
            low = prices[i];
           }
        }
          return profit;
    }
}