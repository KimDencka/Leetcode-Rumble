package kim.dencka.java.easy.collection;

import java.util.*;

class DuplicateZeroes {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
    }

    public static void duplicateZeros(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) stack.add(arr[i]);
        for (int i = 0; i < arr.length; i++) {
            if (stack.peek() != 0) {
                arr[i] = stack.pop();
            } else {
                arr[i++] = stack.pop();
                try {
                    arr[i] = 0;
                } catch (Exception e) {
                    break;
                }
            }
        }
    }
}
