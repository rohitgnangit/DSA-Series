// Leetcode-2182: Construct String With Repeat Limit
// Level-Medium

// Input: s = "cczazcc", repeatLimit = 3
// Output: "zzcccac"
// Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
// The letter 'a' appears at most 1 time in a row.
// The letter 'c' appears at most 3 times in a row.
// The letter 'z' appears at most 2 times in a row.
// Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
// The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
// Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so it is not a valid repeatLimitedString.

class Lexico {
    char ch;
    int count;
    Lexico (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Lexico> pq = new PriorityQueue<>((a, b) -> b.ch-a.ch);

        for (char key:hm.keySet()) {
            Lexico l = new Lexico(key, hm.get(key));
            pq.add(l);
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
           Lexico temp = pq.poll();
           char ch = temp.ch;
           int count = temp.count;
           int cntToBeAdded = Math.min(count, repeatLimit);
            for (int i = 0; i < cntToBeAdded; i++) {
                ans.append(ch);
            }
            if (!pq.isEmpty() && count > repeatLimit) {
                Lexico top = pq.poll();
                char ch2 = top.ch;
                int count2 = top.count;
                ans.append(ch2);
                count2--;
                if (count2 > 0) {
                    pq.add (new Lexico(ch2, count2));
                }
                pq.add(new Lexico(ch, count - repeatLimit));
            }
        }
        return ans.toString();
    }
}