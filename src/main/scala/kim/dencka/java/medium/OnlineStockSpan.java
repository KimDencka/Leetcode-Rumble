package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100)); // 1
        System.out.println(ss.next(80)); // 1
        System.out.println(ss.next(60)); // 1
        System.out.println(ss.next(70)); // 2
        System.out.println(ss.next(60)); // 1
        System.out.println(ss.next(75)); // 4
        System.out.println(ss.next(85)); // 6
    }

    static class StockSpanner {

        Deque<int[]> stack;

        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }
}
