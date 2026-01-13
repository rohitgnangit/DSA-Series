// Q: Remove all occurrences of a character from a string

class Main {
    public static String filter(String s, char ch, int i, StringBuilder sb) {
        if (i == s.length()) return sb.toString();
        if (s.charAt(i) != ch) {
            sb.append(s.charAt(i));
        }
        return filter(s, ch, i+1, sb);
    }
    public static void main(String[] args) {
       String s = "abacda";
       char ch = 'a';
       StringBuilder sb = new StringBuilder();
       int i = 0;
       System.out.println(filter(s, ch, i, sb));
    }
}

// OUTPUT :
// bcd