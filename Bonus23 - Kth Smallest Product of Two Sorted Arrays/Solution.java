class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -1_000_000_0000L, high = 1_000_000_0000L;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countPairs(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long countPairs(int[] A, int[] B, long x) {
        long count = 0;
        for (int a : A) {
            if (a > 0) {
                int l = 0, r = B.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * B[m] <= x) l = m + 1;
                    else r = m;
                }
                count += l;
            } else if (a < 0) {
                int l = 0, r = B.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * B[m] <= x) r = m;
                    else l = m + 1;
                }
                count += B.length - l;
            } else {
                if (x >= 0) count += B.length;
            }
        }
        return count;
    }
}
