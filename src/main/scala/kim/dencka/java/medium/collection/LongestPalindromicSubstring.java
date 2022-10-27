package kim.dencka.java.medium.collection;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abaxyzzyxf"));
    }

    public static String longestPalindrome(String s) {
        int[] longest = {0, 1};
        int[] cur, odd, even;
        for (int i = 1; i < s.length(); i++) {
            odd = getPalindrome(i - 1, i + 1, s);
            even = getPalindrome(i - 1, i, s);
            cur = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            longest = longest[1] - longest[0] > cur[1] - cur[0] ? longest : cur;
        }
        return s.substring(longest[0], longest[1]);
    }

    public static int[] getPalindrome(int left, int right, String str) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) break;
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }
}
