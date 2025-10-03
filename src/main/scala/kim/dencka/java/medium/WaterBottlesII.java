package kim.dencka.java.medium;

public class WaterBottlesII {
    public static void main(String[] args) {
//        System.out.println(maxBottlesDrunk(13, 6)); // 15
        System.out.println(maxBottlesDrunk(3, 1)); // 5
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int result = numBottles;
        while (true) {
            if (numBottles >= numExchange) {
                numBottles -= numExchange;
                result++;
                numBottles++;
            }
            if (numBottles < numExchange) break;
            numExchange++;
        }

        return result;
    }
}
