package kim.dencka.java.medium.other;

import java.util.*;

class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b1"));
    }

    // Recursive, Backtracking
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        permute(0, s.toCharArray(), result);
        return result;
    }

    private static void permute(int i, char[] chars, List<String> res) {
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }
        char ch = chars[i];
        if (Character.isLetter(ch)) {
            chars[i] = Character.toUpperCase(ch);
            permute(i + 1, chars, res);
            chars[i] = Character.toLowerCase(ch);
            permute(i + 1, chars, res);
        } else {
            permute(i + 1, chars, res);
        }
    }

    // Iterative
//    public List<String> letterCasePermutation(String s) {
//        List<String> result = new ArrayList<>();
//        result.add(s.toLowerCase());
//        int size;
//        char cur;
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < s.length(); i++) {
//            cur = chars[i];
//            if (cur >= '0' && cur <= '9') continue;
//
//            size = result.size();
//            for (int j = 0; j < size; j++)
//                result.add(toUpperCase(result.get(j), i));
//        }
//
//        return result;
//    }
//
//    private String toUpperCase(String str, int ind) {
//        char[] chars = str.toCharArray();
//        char ch = chars[ind];
//        chars[ind] = (char) (ch - 'a' + 'A');
//        return new String(chars);
//    }
}
