class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort by start time

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]); // Merge
            } else {
                merged.add(current);
                current = intervals[i]; // Move to next
            }
        }

        merged.add(current); // Add last interval
        return merged.toArray(new int[merged.size()][]);
    }
}
