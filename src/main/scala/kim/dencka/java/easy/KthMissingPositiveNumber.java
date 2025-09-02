package kim.dencka.java.easy;

class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 11};
        System.out.println(findKthPositive(nums, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        for (int j : arr) {
            if (k >= j) k++;
            else break;
        }
        return k;
    }

    // binary search
//    public static int findKthPositive(int[] arr, int k) {
//        int start = 0;
//        int end = arr.length;
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] - mid - 1 < k) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//        return start + k;
//    }


}
