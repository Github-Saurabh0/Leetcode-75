public class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] seen = new boolean[n];
        boolean[] hasKey = new boolean[n];
        boolean[] canOpen = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            seen[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                canOpen[box] = true;
            }
        }

        int totalCandies = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            totalCandies += candies[curr];

            for (int k : keys[curr]) {
                if (!hasKey[k]) {
                    hasKey[k] = true;
                    if (seen[k] && !canOpen[k]) {
                        queue.offer(k);
                        canOpen[k] = true;
                    }
                }
            }

            for (int b : containedBoxes[curr]) {
                seen[b] = true;
                if (status[b] == 1 || hasKey[b]) {
                    if (!canOpen[b]) {
                        queue.offer(b);
                        canOpen[b] = true;
                    }
                }
            }
        }

        return totalCandies;
    }
}