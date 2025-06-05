class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];       // maximum sum so far
        int currentSum = nums[0];   // current running subarray sum

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // naye element se start ya add
            maxSum = Math.max(maxSum, currentSum);                // max sum update karo
        }

        return maxSum;  // final answer return karo
    }
}