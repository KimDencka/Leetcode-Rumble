package kim.dencka.java.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
        System.out.println(isHappy(2)); // false
        System.out.println(isHappyTwoPointers(19)); // true
        System.out.println(isHappyTwoPointers(2)); // false
    }

    public static boolean isHappy(int n) {
        int num = n;
        Set<Integer> seen = new HashSet<>();
        while (num != 1) {
            int newNum = squareSum(num);
            if (seen.contains(newNum)) return false;
            seen.add(newNum);
            num = newNum;
        }

        return true;
    }

    public static boolean isHappyTwoPointers(int n) {
        int slow = n, fast = n;

        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int squareSum(int num) {
        int result = 0;
        while (num != 0) {
            int rem = num % 10;
            result += rem * rem;
            num /= 10;
        }
        return result;
    }
}
