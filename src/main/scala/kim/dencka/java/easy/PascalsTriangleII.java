package kim.dencka.java.easy;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i > 0) row.add(1);
            result.add(row);
        }
        return result.get(result.size() - 1);
    }
}
