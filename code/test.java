import java.util.Arrays;

class Solution {
    static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];

    }

    public static void main(String[] args) {
        int[] t = new int[] { 1, 2, 3, 4 };
        swap(t,2,1);
        System.out.println(Arrays.toString(t));
    }
}