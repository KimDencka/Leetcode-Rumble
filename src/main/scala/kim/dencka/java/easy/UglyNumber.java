package kim.dencka.java.easy;

class UglyNumber {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factors = new int[]{2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) n = n / factor;
        }
        return n == 1;
    }
}
