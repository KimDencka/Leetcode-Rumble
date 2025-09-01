package kim.dencka.java.easy.other;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String input1 = "IceCreAm";
        System.out.println(reverseVowels(input1)); // "AceCreIm"

        String input2 = "leetcode";
        System.out.println(reverseVowels(input2)); // "leotcede"
    }

    public static String reverseVowels(String s) {
        String vowels = "aeiouAEIOU"; // why not Set? because it is a short String, it will be a little bit faster
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && vowels.indexOf(chars[l]) == -1) l++;
            while (l < r && vowels.indexOf(chars[r]) == -1) r--;

            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}
