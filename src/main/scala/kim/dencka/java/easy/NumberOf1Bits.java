package kim.dencka.java.easy;

class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(0b00000000000000000000000000001011)); // 521
        System.out.println(hammingWeight(0b11111111111111111111111111111101));
    }

    public static int hammingWeight(int n) {
        int res;
        for (res = 0; n != 0; res++) n &= n - 1;
        return res;
    }

//    public static int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            if ((n & 1) == 1)
//                res++;
//            n = n >> 1;
//        }
//        return res;
//    }
}
