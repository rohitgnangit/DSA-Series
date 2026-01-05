// Q: Summation of 'n' numbers using Parameterized Recursion


class Main {
    public static void summation(int n, int sum) {
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        summation(n-1, sum+n);
    }
    public static void main(String[] args) {
        int sum = 0;
        int n = 3;
        summation(n, sum);
    }
}

// OUTPUT :
// 6