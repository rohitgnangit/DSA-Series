// Leetcode-735: Asteroid Collision
// Level-Medium

// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (!st.isEmpty() && asteroid < 0) {
                int negAsteroid = Math.abs(asteroid);
                boolean alive = true;
                while (!st.isEmpty() && (st.peek() > 0) && alive) {
                    if (st.peek() < negAsteroid) {
                        st.pop();
                    } else if (st.peek() == negAsteroid) {
                        st.pop();
                        alive = false;
                    } else {
                        alive = false;
                    }
                }
                    if (alive) {
                        st.push(asteroid);
                    }
            } else {
                st.push(asteroid);
            }
        }
        int[] res = new int[st.size()];
        for (int i = st.size()-1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}