package kim.dencka.java.easy.collection;

class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    static int i;
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                res.append(rev(str[i].length() - 1, str[i]));
            } else {
                res.append(rev(str[i].length() - 1, str[i]));
                res.append(' ');
            }
        }
        return res.toString();
    }

    private static String rev(int j, String s) {
        i = 0;
        char[] chars = s.toCharArray();
        char tm;
        while (i < j) {
            tm = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tm;
        }
        return new String(chars);
    }
}
