package kim.dencka.java.medium.other;

import java.util.*;

class LetterCasePermutation {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b1"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        result.add(s.toLowerCase());
        int size;
        char cur;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            cur = chars[i];
            if (cur >= '0' && cur <= '9') continue;

            size = result.size();
            for (int j = 0; j < size; j++)
                result.add(toUpperCase(result.get(j), i));
        }

        return result;
    }

    private static String toUpperCase(String str, int ind) {
        char[] chars = str.toCharArray();
        char ch = chars[ind];
        chars[ind] = (char) (ch - 'a' + 'A');
        return new String(chars);
    }
}
