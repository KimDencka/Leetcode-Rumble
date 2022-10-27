package kim.dencka.java.medium.collection;

class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach < i) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}
