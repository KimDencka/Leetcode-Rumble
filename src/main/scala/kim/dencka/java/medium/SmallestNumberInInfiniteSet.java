package kim.dencka.java.medium;

import java.util.TreeSet;

public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        System.out.println(set.popSmallest()); // 1
        System.out.println(set.popSmallest()); // 2
        System.out.println(set.popSmallest()); // 3
        set.addBack(1);
        System.out.println(set.popSmallest()); // 1
        System.out.println(set.popSmallest()); // 4
        System.out.println(set.popSmallest()); // 5
    }

    static class SmallestInfiniteSet {
        private int next;
        private final TreeSet<Integer> addedBack;

        public SmallestInfiniteSet() {
            this.next = 1;
            this.addedBack = new TreeSet<>();
        }

        public int popSmallest() {
            if (!addedBack.isEmpty()) {
                return addedBack.pollFirst();
            }
            return next++;
        }

        public void addBack(int num) {
            if (num < next) {
                addedBack.add(num);
            }
        }
    }
}
