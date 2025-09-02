package kim.dencka.java.easy;

class ReverseBit {
    public static void main(String[] args) {
        int input = reverseBits(0b00000010100101000001111010011100);
        StringBuilder s = new StringBuilder("000000101001010000011110100111");
        System.out.println(Integer.toBinaryString(input).equals(s.reverse().toString())); // true
    }

    public static int reverseBits(int n) {
        int result = 0, bit;
        for (int i = 0; i < 32; i++) {
            bit = n & 1;
            result <<= 1;
            result = result | bit;
            n >>= 1;
        }
        return result;
    }
}
