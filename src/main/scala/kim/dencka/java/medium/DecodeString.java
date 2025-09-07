package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[abc2[def]]";
        System.out.println(decodeString(s)); // abcdefdefabcdefdefabcdefdef
    }

    public static String decodeString(String s) {
        Deque<Integer> repeats = new ArrayDeque<>();
        Deque<StringBuilder> segments = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int repeat = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                repeat = (repeat * 10) + ch - '0';
            } else if (ch == '[') {
                repeats.addLast(repeat);
                repeat = 0;
                segments.addLast(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int n = repeats.pollLast();
                StringBuilder temp = sb;
                sb = segments.pollLast();
                while (n-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
