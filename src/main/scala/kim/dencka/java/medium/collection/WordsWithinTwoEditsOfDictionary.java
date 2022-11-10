package kim.dencka.java.medium.collection;

import java.util.ArrayList;
import java.util.List;

class WordsWithinTwoEditsOfDictionary {
    public static void main(String[] args) {
        String[] queries = {"vkvbuh", "usgkoz", "fogezn", "cgtkwr", "dbzgvv"};
        String[] dictionary = {"hfosud", "aaxhkp", "vkvbua", "xhqibo", "mgxzer", "ybzgvv", "fsgkoz"};

        System.out.println(twoEditWords(queries, dictionary));
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (isSimilar(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isSimilar(String str1, String str2) {
        int len = str1.length();
        if (len <= 2) return true;
        int similarity = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                similarity++;
        }
        return len - similarity <= 2;
    }
}
