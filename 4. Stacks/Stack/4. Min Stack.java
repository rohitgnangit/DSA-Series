// Leetcode-155: Min Stack
// Level-Medium

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2


class MinStack {
    Stack<Integer> s;
    Stack<Integer> st;
    public MinStack() {
        s = new Stack<>();
        st = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(st.isEmpty() || val <= st.peek()) {
            st.push(val);
        }
    }
    
    public void pop() {
        if (s.peek().equals(st.peek())) {
            st.pop();
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return st.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */