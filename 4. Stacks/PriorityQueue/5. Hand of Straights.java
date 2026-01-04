// Leetcode-846: Hand of Straights
// Level-Medium

// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

// Example 1:
// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

class Freq {
    int num;
    int count;
    Freq(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Edge Case
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            int key = hand[i];
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }

        PriorityQueue<Freq> pq1 = new PriorityQueue<>((a, b) -> a.num-b.num);
        for (int key:hm.keySet()) {
            Freq f = new Freq(key, hm.get(key));
            pq1.add(f);
        }
        while (!pq1.isEmpty()) {
            PriorityQueue<Freq> pq2 = new PriorityQueue<>((a, b) -> a.num-b.num);
            int size  = groupSize;
            int num = 0;
            int count = 0;
            while(!pq1.isEmpty() && size > 0) {
                Freq top = pq1.poll();
                // Skipping the first iteration, "num is previous" "top.num is current" both are comparing for if the sequence is consecutive or not.
                if (size != groupSize && top.num != num+1) {
                    return false;
                }
                num = top.num;
                count = top.count;
                count--;
                size--;
                if (count > 0) {
                    pq2.add(new Freq(num, count));
                }
            }
            // If "size is != 0" then Queue contains single number so we cant make consecutive order
            if (size != 0) {
                return false;
            }
            while(!pq2.isEmpty()) {
                Freq temp = pq2.poll();
                pq1.add(temp);
            }
        }
        return true;
    }
}