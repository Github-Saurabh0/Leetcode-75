import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;

        // Precompute powers of 2
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, count = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count = (count + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
