package kim.dencka.java.easy.collection;

import java.util.HashMap;
import java.util.Map;

class OddStringDifference {
    public static void main(String[] args) {
        String[] words = {"abm", "bcn", "alm"};
        System.out.println(oddString(words));
        System.out.println(getDifference("abm"));
        System.out.println(getDifference("alm"));
        System.out.println(getDifference("bcn"));
    }

    public static String oddString(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> wordsPair = new HashMap<>();
        for (String word : words) {
            String diff = getDifference(word);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
            wordsPair.put(diff, word);
            System.out.println(map);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return wordsPair.get(entry.getKey());
        }
        return "";
    }

    public static String getDifference(String str) {
        String[] res = new String[str.length() - 1];
        for (int i = 0; i < str.length() - 1; i++) {
            res[i] = String.valueOf(str.charAt(i + 1) - str.charAt(i));
        }
        return String.join(",", res);
    }
}
