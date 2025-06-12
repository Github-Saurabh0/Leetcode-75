class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;  // sab numbers ka sum nikalo
        }

        if (total % 2 != 0) {
            return false;  // agar total odd hai toh equal 2 parts possible nahi
        }

        int target = total / 2;  // hume sum = total/2 ka subset chahiye
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 0 sum toh empty subset se ho hi sakta hai

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                // is sum i tak pahuchne ka ek tareeka hai ki i - num pe already true ho
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];  // kya target sum possible hai?
    }
}
