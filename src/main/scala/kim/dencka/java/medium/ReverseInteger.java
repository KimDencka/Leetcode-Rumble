package kim.dencka.java.medium;

class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    // time: 1 ms, mem: 39.6 MB
    public static int reverse(int x) {
        int temp = Math.abs(x);
        int length = 0;
        while (temp > 0) {
            temp /= 10;
            length++;
        }
        int result = 0;
        int cur;
        for (int i = 1; i <= length; i++) {
            cur = result * 10 + (x % 10);
            if (cur / 10 != result) return 0;
            result = cur;
            x /= 10;
        }

        return result;
    }

    //  The same solution without second loop, but slower. Why?
    // time: 2 ms, mem: 41 MB
//    public static int reverse(int x) {
//        int result = 0;
//        int cur;
//        while (x != 0) {
//            cur = result * 10 + (x % 10);
//            if (cur / 10 != result) return 0;
//            result = cur;
//            x /= 10;
//        }
//        return result;
//    }
}
