package kim.dencka.java.medium;

import java.util.*;

class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        printlnAll(fourSum(nums, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length - 1; j >= 3; j--) {
                int l = i + 1;
                int r = j - 1;
                long curSum;
                while (l < r) {
                    curSum = (long) nums[l] + nums[i] + nums[j] + nums[r];
                    boolean isValid = (curSum > min && curSum < max);
                    if (curSum > target) {
                        r--;
                    } else if (curSum < target) {
                        l++;
                    } else if (isValid && curSum == target) {
                        set.add(List.of(nums[i], nums[l], nums[r], nums[j]));
                        r--;
                        l++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void printlnAll(List<List<Integer>> list) {
        list.forEach(num -> System.out.println(num.get(0) + " " + num.get(1) + " " + num.get(2) + " " + num.get(3)));
    }

}
