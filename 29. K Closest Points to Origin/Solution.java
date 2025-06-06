class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // MaxHeap to store k closest points
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point);  // point add karo
            if (maxHeap.size() > k)
                maxHeap.poll();    // sabse door point hatao (size > k)
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = maxHeap.poll();  // final k points

        return result;
    }

    // Helper method to compute squared Euclidean distance from origin
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
