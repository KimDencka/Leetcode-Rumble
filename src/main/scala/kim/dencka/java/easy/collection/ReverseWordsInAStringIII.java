package kim.dencka.java.easy.collection;

class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 32) {
                result.append(temp.reverse());
                result.append(' ');
                temp.setLength(0);
            } else {
                temp.append(ch);
            }
        }
        result.append(temp.reverse());
        return result.toString();
    }
}
