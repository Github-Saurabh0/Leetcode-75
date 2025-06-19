class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - min > k) {
                count++;
                min = nums[i];
            }
        }

        return count;
    }
}
