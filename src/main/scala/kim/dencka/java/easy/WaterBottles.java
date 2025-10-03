package kim.dencka.java.easy;

public class WaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(15, 4)); // 19
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            result += (numBottles / numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }

        return result;
    }
}
