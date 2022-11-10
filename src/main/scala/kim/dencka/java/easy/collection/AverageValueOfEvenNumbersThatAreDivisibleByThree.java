package kim.dencka.java.easy.collection;

class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public static void main(String[] args) {
        System.out.println(averageValue(new int[]{1, 3, 6, 10, 12, 15}));
    }

    public static int averageValue(int[] nums) {
        int cnt = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
