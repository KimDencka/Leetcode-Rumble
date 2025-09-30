package kim.dencka.java.medium;

public class MinimizeXOR {
    public static void main(String[] args) {
        System.out.println(minimizeXor(1, 12)); // 3
        System.out.println(minimizeXor2(1, 12)); // 3
    }

    public static int minimizeXor(int num1, int num2) {
        int result = 0;
        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;
        int currentBit = 31;

        while (targetSetBitsCount > setBitsCount) {
            if (isSet(num1, currentBit) || targetSetBitsCount - setBitsCount > currentBit) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit--;
        }

        return result;
    }

    // Helper function to check if the given bit position in result is set (1).
    private static boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    // Helper function to set the given bit position in result to 1.
    private static int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    // Helper function to unset the given bit position in x (set it to 0).
    private static int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }

    public static int minimizeXor2(int num1, int num2) {
        int result = num1;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);
        int currentBit = 0;

        // Add bits to result if it has fewer set bits than the target.
        while (setBitsCount < targetSetBitsCount) {
            if (!isSet(result, currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            currentBit++;
        }

        // Remove bits from result if it has more set bits than the target.
        while (setBitsCount > targetSetBitsCount) {
            if (isSet(result, currentBit)) {
                result = unsetBit(result, currentBit);
                setBitsCount--;
            }
            currentBit++;
        }

        return result;
    }
}
