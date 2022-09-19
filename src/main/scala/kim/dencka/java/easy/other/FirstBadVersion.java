package kim.dencka.java.easy.other;

class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int low = 0, high = n, mid;
        int result = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }


    public static boolean isBadVersion(int version) {
        System.out.println(version);
        return false;
    }

}
