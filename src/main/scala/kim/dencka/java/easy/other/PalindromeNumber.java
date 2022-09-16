package kim.dencka.java.easy.other;

class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reversed = 0;
        int temp = x;
        while (temp != 0) {
            reversed = reversed  * 10 + (temp % 10);
            temp /= 10;
        }
        return reversed == x;
    }
}
