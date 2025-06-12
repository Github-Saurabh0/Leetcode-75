class Solution {
    public void sortColors(int[] nums) {
        int low = 0;              0 ke liye pointer
        int mid = 0;              current index jise traverse krna hai
        int high = nums.length - 1;  2 ke liye pointer

        while (mid = high) {
            if (nums[mid] == 0) {
                 agar current element 0 hai, toh usse low index ke saath swap karo
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;     0 area badhao
                mid++;     next element par jao
            } else if (nums[mid] == 1) {
                 agar 1 hai toh usse wahi chhodo aur next par jao
                mid++;
            } else {
                 agar 2 hai toh usse high index ke saath swap karo
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;    2 area peeche le jao
                 mid ko badhao nahi, kyuki swap k baad aaya element check karna padega
            }
        }
    }
}
