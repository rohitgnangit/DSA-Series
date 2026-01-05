// Q: Summation of 'n' numbers using Functional Recursion


class Main {
    public static int summation(int n) {
        if (n == 0) {
            return 0;
        }
        return n + summation(n-1);
    }
    public static void main(String[] args) {
        int n = 3;
        int sum = summation(n);
        System.out.println(sum);
    }
}

// OUTPUT :
// 6
