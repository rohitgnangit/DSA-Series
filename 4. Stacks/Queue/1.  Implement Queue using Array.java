// Q:  Implement Queue using Array

class ArrayQueue {
    int[] qArr ;
    int start;
    int end;
    public ArrayQueue() {
        qArr = new int[10];
        start = 0;
        end = -1;
    }

    public void push(int x) {
        end += 1;
       qArr[end] = x;
    }

    public int pop() {
      int remove = qArr[start]
      start += 1;
      return remove;
    }

    public int peek() {
        return qArr[start];
    }

    public boolean isEmpty() {
        if (start > end) return true;
        return false;
    }
}