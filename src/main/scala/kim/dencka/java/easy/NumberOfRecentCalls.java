package kim.dencka.java.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        counter.ping(1);    // 1
        counter.ping(100);  // 2
        counter.ping(3001); // 3
        counter.ping(3002); // 3
    }


}

class RecentCounter {
    Deque<Integer> calls = new ArrayDeque<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        calls.offer(t);
        while (calls.peek() < t - 3000) {
            calls.poll();
        }
        return calls.size();
    }
}