package kim.dencka.java.easy.other;

class N_thTribonacciNumber {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        System.out.println(tribonacci(1)); // 1
        System.out.println(tribonacci(4)); // 4
        System.out.println(tribonacci(8)); // 44
        System.out.println(tribonacci(15)); // 3136
    }

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int step = 2;
        int i = 0, j = 1, k = 1;
        int res = 0;
        while (step != n) {
            res = i + j + k;
            i = j;
            j = k;
            k = res;
            step++;
        }

        return res;
    }
}
