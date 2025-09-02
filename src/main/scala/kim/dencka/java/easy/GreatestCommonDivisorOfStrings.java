package kim.dencka.java.easy;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println("#1: " + gcdOfStrings(str1, str2));

        String str3 = "ABABAB", str4 = "ABAB";
        System.out.println("#2: " + gcdOfStrings(str3, str4));

        String str5 = "LEET", str6 = "CODE";
        System.out.println("#3: " + gcdOfStrings(str5, str6));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
