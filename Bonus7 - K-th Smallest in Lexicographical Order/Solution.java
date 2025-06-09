class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k -= 1;

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                k -= steps;
                current += 1;
            } else {
                current *= 10;
                k -= 1;
            }
        }

        return current;
    }

    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1L, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
