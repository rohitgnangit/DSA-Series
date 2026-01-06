// Q: Check if the given string is palindrome or not using Functional Recursion.

class Main {
    public static boolean isPalindrome(String s, int l, int r) {
        if(l >= r) return true;
        if(s.charAt(l) != s.charAt(r)) {
            return false;
        }
        return isPalindrome(s, l+1, r-1);
    }
    public static void main(String[] args) {
        String s = "malayalam";
        int l = 0;
        int r = s.length()-1;
        System.out.println(isPalindrome(s, l, r));
    }
}

// OUTPUT :
// True