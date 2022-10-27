package kim.dencka.java.easy.collection;

class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
    }

    public static int arrangeCoins(int n) {
        long low = 0;
        long high = n;
        while (low <= high) {
            long mid = (low + (high - low) / 2);
            long curr = mid * (mid + 1) / 2;

            if (curr == n) return (int) mid;

            if (n < curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }

    // MATH
//    public static int arrangeCoins(int n) {
//        return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
//    }
}
