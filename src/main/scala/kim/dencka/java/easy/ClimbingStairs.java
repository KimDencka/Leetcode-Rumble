package kim.dencka.java.easy;

class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int i = 1, j = 2, step = 2;

        int res = 0;
        while (step != n) {
            res = i + j;
            i = j;
            j = res;
            step++;
        }

        return res;
    }
}
