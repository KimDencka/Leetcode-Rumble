package kim.dencka.java.medium;

public class MinimumFlipsToMakeAORBEqualToC {
    public static void main(String[] args) {
        System.out.println(minFlips(2, 6, 5)); // 3
    }

    public static int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a != 0 || b != 0 || c != 0) {
            int aBit = a & 1, bBit = b & 1, cBit = c & 1;
            if (cBit == 1) {
                if (aBit == 0 && bBit == 0) flips++;
            } else {
                flips += (aBit + bBit);
            }

            a >>>= 1;
            b >>>= 1;
            c >>>= 1;
        }
        return flips;
    }
}
