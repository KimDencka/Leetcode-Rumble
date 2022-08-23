package kim.dencka.java.easy.collection;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                range.add(nums[i]);
            } else {
                if (range.size() == 0) {
                    res.add(nums[i] + "");
                } else {
                    res.add(range.get(0) + "->" + nums[i]);
                    range = new ArrayList<>();
                }
            }
        }
        if (range.size() == 0) {
            if (nums.length != 0) {
                res.add(nums[nums.length - 1] + "");
            }
        } else {
            res.add(range.get(0) + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
