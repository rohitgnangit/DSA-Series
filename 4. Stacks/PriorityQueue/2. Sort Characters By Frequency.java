// Leetcode-451: Sort Characters By Frequency
// Level-Medium

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

// Creating a Object type to store key value pairs in PQ
class Frequency {
    char ch;
    int count;
    Frequency (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        // Giving priority to object by count. if count of the characters same then consider the bigger character
        PriorityQueue<Frequency> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return b.ch - a.ch;
            } else {
                return b.count - a.count;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Frequency f = new Frequency(ch, hm.get(ch));
            pq.add(f);
        }

        String ans = "";
        while (!pq.isEmpty()) {
            Frequency obj = pq.poll();
            ans = ans + obj.ch;
        }
        return ans;
    }
}