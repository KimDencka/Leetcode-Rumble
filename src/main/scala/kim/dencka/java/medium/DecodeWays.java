package kim.dencka.java.medium;

class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("123456204568"));
    }
    static String str;
    static int[] dp;

    public static int numDecodings(String s) {
        str = s;
        dp = new int[str.length()];
        return decode(str.length() - 1);
    }

    private static int decode(int n) {
        if (n < 0) return 1;
        if (dp[n] != 0) return dp[n];
        int res = 0;
        if (oneNumIsValid(n)) res += decode(n - 1);
        if (n - 1 >= 0 && twoNumsAreValid(n - 1)) res += decode(n - 2);
        dp[n] = res;
        return res;
    }

    private static boolean oneNumIsValid(int n) {
        return str.charAt(n) != '0';
    }

    private static boolean twoNumsAreValid(int n) {
        if (str.charAt(n) == '1') return true;
        else return str.charAt(n) == '2' && str.charAt(n + 1) >= '0' && str.charAt(n + 1) <= '6';
    }
}