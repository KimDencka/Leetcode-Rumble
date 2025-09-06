package kim.dencka.java.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int top = -1;
        for (int cur : asteroids) {
            boolean alive = true;
            while (top >= 0 && cur < 0 && asteroids[top] > 0) {
                int last = asteroids[top];
                if (last < -cur) {
                    top--;
                    continue;
                } else if (last == -cur) {
                    top--;
                }
                alive = false;
                break;
            }
            if (alive) asteroids[++top] = cur;
        }

        return Arrays.copyOfRange(asteroids, 0, top + 1);
    }

//    public static int[] asteroidCollision(int[] asteroids) {
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        for (int a : asteroids) {
//            boolean alive = true;
//
//            while (alive && a < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
//                int b = stack.peekLast();
//                if (b < -a) {
//                    stack.pollLast();
//                } else if (b == -a) {
//                    stack.pollLast();
//                    alive = false;
//                } else {
//                    alive = false;
//                }
//            }
//
//            if (alive) stack.addLast(a);
//        }
//
//        int[] result = new int[stack.size()];
//        for (int i = result.length - 1; i >= 0; i--) {
//            result[i] = stack.pollLast();
//        }
//
//        return result;
//    }
}
