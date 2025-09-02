package kim.dencka.java.medium;

class MinimumAdditionToMakeIntegerBeautiful {
    public static void main(String[] args) {
        long res = makeIntegerBeautiful(734504727, 10);
        System.out.println(res);
    }

    public static long makeIntegerBeautiful(long n, int target) {
        long n0 = n, base = 1;
        while (getSum(n) > target) {
            n = n / 10 + 1;
            base *= 10;
        }
        return n * base - n0;
    }

    public static long getSum(long n) {
        if (n < 10) return n;
        return n % 10 + getSum(n / 10);
    }
}
