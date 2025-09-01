package kim.dencka.java.easy.collection;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String input1 = "abc";
        String input2 = "pqr";

        System.out.println(mergeAlternately(input1, input2));

        String input3 = "ab";
        String input4 = "pqrs";

        System.out.println(mergeAlternately(input3, input4));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) result.append(word1.charAt(i));
            if (i < word2.length()) result.append(word2.charAt(i));
            i++;
        }
        return result.toString();
    }

//    public static String mergeAlternately(String word1, String word2) {
//        StringBuilder sb = new StringBuilder();
//        int len1 = word1.length();
//        int len2 = word2.length();
//
//        int minLen = Math.min(len1, len2);
//        for (int i = 0; i < minLen; i++) {
//            sb.append(word1.charAt(i));
//            sb.append(word2.charAt(i));
//            if (i == minLen - 1) {
//                if (len1 < len2) {
//                    sb.append(word2.substring(i + 1));
//                } else {
//                    sb.append(word1.substring(i + 1));
//                }
//            }
//        }
//        return sb.toString();
//    }
}
