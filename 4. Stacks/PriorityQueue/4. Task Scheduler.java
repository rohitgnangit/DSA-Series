// Leetcode-621: Task Scheduler
// Level-Medium

// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
// Return the minimum number of CPU intervals required to complete all tasks.

// Example 1:
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
// After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.


class Freq {
    char ch;
    int count;
    Freq (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            char ch = tasks[i];
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Freq> pq1 = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (char ch:hm.keySet()) {
            Freq f = new Freq(ch, hm.get(ch));
            pq1.add(f);
        }

        int ans = 0;
        while (!pq1.isEmpty()) {
            int range = n + 1;
            PriorityQueue<Freq> pq2 = new PriorityQueue<>((a, b) -> b.count - a.count);
        
            while (range > 0 && !pq1.isEmpty()) {
                    Freq top = pq1.poll();
                    char ch = top.ch;
                    int count = top.count;
                    ans++;
                    count--;
                    range--;
                    if (count > 0) {
                        pq2.add(new Freq(ch, count));
                    }
            }
            while (!pq2.isEmpty()) {
                Freq temp = pq2.poll();
                pq1.add(temp);
            }
            // The idles should not add at last
            if(!pq1.isEmpty()) {
                ans += range;
            }
        }
        return ans;
    }
}