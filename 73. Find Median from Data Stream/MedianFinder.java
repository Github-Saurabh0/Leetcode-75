import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left half
    private PriorityQueue<Integer> minHeap; // right half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        minHeap = new PriorityQueue<>(); // Min Heap
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}
