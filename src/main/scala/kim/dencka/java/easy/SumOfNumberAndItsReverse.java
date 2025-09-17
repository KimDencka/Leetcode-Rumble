package kim.dencka.java.easy;

class SumOfNumberAndItsReverse {
    public static void main(String[] args) {
        System.out.println(sumOfNumberAndReverse(443)); // true
    }

    public static boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int reversed = reverse(i);
            if (i + reversed == num) return true;
        }
        return false;
    }

    private static int reverse(int num) {
        int r = 0;
        while (num != 0) {
            r = r * 10 + num % 10;
            num /= 10;
        }
        return r;
    }
}
