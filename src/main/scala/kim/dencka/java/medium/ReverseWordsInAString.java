package kim.dencka.java.medium;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // "blue is sky the"
        System.out.println(reverseWords("  hello world  ")); // "world hello"
        System.out.println(reverseWords("a good   example")); // "example good a"
    }

    // * '\s+' - регулярное выражение, которое определяет пробельный символ или цепочку.
    // * '\s' означает любой пробельный символ (пробел, табуляция, перевод строки и т.д.).
    // * '+' означает один или больше раз.
    // ? Не учитывает пробелы в начале и в конце!
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int l = 0;
        int r = words.length - 1;
        while (l < r) {
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }
        return String.join(" ", words);
    }

//    public String reverseWords(String s) {
//        String[] words = s.split("\\s+");
//        StringBuilder res = new StringBuilder();
//
//        for (int i = words.length - 1; i >= 0; i--) {
//            res.append(words[i]);
//            if (i != 0) {
//                res.append(" ");
//            }
//        }
//
//        return res.toString().trim();
//    }
}
