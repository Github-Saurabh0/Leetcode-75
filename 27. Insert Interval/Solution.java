class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        // Step 1: Add all intervals that end before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Step 2: Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);  // merged interval add karo

        // Step 3: Add remaining intervals
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
