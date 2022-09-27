package kim.dencka.java.easy.collection;

class FindTheDistanceValueBetweenTwoArrays {
    // KIM_INFO NOT SOLVED IN SCALA

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 100, 3};
        int[] arr2 = {-5, -2, 10, -3, 7};
        System.out.println(findTheDistanceValue(arr1, arr2, 6));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        int j = 0;
        for (int k : arr1) {
            while (j < arr2.length) {
                if (Math.abs(k - arr2[j]) <= d) break;
                j++;
            }
            if (j == arr2.length) res++;
        }
        return res;
    }
}
