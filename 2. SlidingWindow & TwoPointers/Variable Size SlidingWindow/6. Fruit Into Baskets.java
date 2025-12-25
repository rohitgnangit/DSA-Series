// Leetcode-904: Fruit Into Baskets
// Level-Medium

// Q: You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
//    You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
//    You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
//    Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
//    Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
//    Given the integer array fruits, return the maximum number of fruits you can pick.

// Input: fruits = [1,2,1]
// Output: 3
// Explanation: We can pick from all 3 trees.

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = fruits.length;
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            int key = fruits[r];
            // HashMap contains two baskets(two keys) and no of key values are the no of fruits the basket contains
            hm.put(key, hm.getOrDefault(key, 0)+1);
            // if baskets want to become above two then make empty of first basket.
            while (hm.size() > 2) {
                int leftKey = fruits[l];
                hm.put(leftKey, hm.get(leftKey) - 1);
                if (hm.get(leftKey) == 0) {
                    hm.remove(leftKey);
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}