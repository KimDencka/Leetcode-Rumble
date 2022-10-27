package kim.dencka.java.medium.collection;

import java.util.*;

class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4, 3, 4, 5, 6, 7, 8, 9, -2, -3, -5, -6, -7, -8};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int curSum;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                curSum = nums[i] + nums[l] + nums[r];
                if (curSum > target) {
                    r--;
                } else if (curSum < target) {
                    l++;
                } else {
                    return target;
                }
                if (Math.abs(res - target) > Math.abs(curSum - target)) {
                    res = curSum;
                }
                System.out.println(res);
            }
        }
        return res;
    }
}
