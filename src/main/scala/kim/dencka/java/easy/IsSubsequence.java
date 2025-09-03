package kim.dencka.java.easy;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        char[] ss = s.toCharArray(); // using array is faster
        char[] tt = t.toCharArray(); // get using index faster than 'charAt' method of the String class.

        while (i < ss.length && j < tt.length) {
            if (ss[i] == tt[j]) i++;
            j++;
        }

        return i == ss.length;
    }
}
