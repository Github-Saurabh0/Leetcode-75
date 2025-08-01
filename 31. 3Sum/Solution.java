class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Pehle sort karo
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;  // Duplicate skip karo

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;  // duplicate left
                    while (left < right && nums[right] == nums[right - 1]) right--;  // duplicate right
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Sum chhota hai → bada number lo
                } else {
                    right--;  // Sum zyada hai → chhota number lo
                }
            }
        }

        return result;
    }
}
