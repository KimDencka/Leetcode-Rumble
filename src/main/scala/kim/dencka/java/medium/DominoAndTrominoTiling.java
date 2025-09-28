package kim.dencka.java.medium;

public class DominoAndTrominoTiling {
    public static void main(String[] args) {
        System.out.println(numTilings(4)); // 11
    }

    public static int numTilings(int n) {
        if (n <= 2) return n;
        int MOD = 1_000_000_007;

        long f0 = 1;
        long f1 = 1;
        long f2 = 2;
        for (int i = 3; i <= n; i++) {
            long f = ((2L * f2) % MOD + f0) % MOD;
            f0 = f1;
            f1 = f2;
            f2 = f;
        }
        return (int) f2;
    }
}
