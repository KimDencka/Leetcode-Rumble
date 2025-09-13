package kim.dencka.java.easy;

public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(2));
    }

    static int pickedNumber = 2;

    public static int guessNumber(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int mid = (h + l) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            if (res == -1) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    public static int guess(int num) {
        return Integer.compare(pickedNumber, num);
    }
}
