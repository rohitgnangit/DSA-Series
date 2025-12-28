// Q: Implement Stack using Array

class ArrayStack {
    int[] arrSt;
    int top;
    public ArrayStack() {
        arrSt = new int[10];
        top = -1;
    }

    public void push(int x) {
        top += 1;
        arrSt[top] = x;
    }

    public int top() {
        return arrSt[top];
    }
    
    public int pop() {
      int remove = arrSt[top];
        top -= 1;
        return remove;
    }

    public boolean isEmpty() {
        if (top == -1) return true;
        return false;
    }
}