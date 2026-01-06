// Q: Find the 'n'th Fibonacci number

class Main {
    public static int fibonacci(int n) {
        if(n <= 1) return n;
        int last = fibonacci(n-1); // First Recursion Call
        int secLast = fibonacci(n-2); // Second Recursion Call
        return last + secLast;
    }
    
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacci(n));
    }
}

// OUTPUT :
// 3
