package kim.dencka.java.easy;

class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(0)); // 0
        System.out.println(fib(1)); // 1
        System.out.println(fib(5)); // 5
        System.out.println(fib(10)); // 55
        System.out.println(fib(20)); // 6765
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int step = 2;
        int i = 1, j = 1, res = 0;
        while (step != n) {
            res = i + j;
            j = i;
            i = res;
            step++;
        }
        return res;
    }
}
