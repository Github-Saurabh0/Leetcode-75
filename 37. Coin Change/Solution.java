class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);  // Initialize with a large value
        dp[0] = 0;  // 0 coins needed to make amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);  // Use the coin
            }
        }

        return dp[amount] == max ? -1 : dp[amount];  // -1 if no solution
    }
}
