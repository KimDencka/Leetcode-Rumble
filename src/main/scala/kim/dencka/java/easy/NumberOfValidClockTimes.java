package kim.dencka.java.easy;

class NumberOfValidClockTimes {
    public static void main(String[] args) {
        System.out.println(countTime("?5:00")); // 2
    }

    public static int countTime(String time) {
        int res = 1;
        char[] t = time.toCharArray();
        if (t[4] == '?') res = res * 10;
        if (t[3] == '?') res = res * 6;
        if (t[0] == '?' & t[1] == '?') res = res * 24;
        else {
            if (t[1] == '?') {
                if (t[0] == '2') res = res * 4;
                else res = res * 10;
            } else if(t[0] == '?'){
                if (t[1] < '4') res = res * 3;
                else res = res * 2;
            }
        }
        return res;
    }
}
