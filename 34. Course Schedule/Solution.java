class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Step 1: Initialize graph
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // Step 2: Build graph & indegree
        for (int[] pre : prerequisites) {
            int course = pre[0], prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Push courses with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.offer(i);

        // Step 4: Process queue
        int completed = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            completed++;
            for (int next : graph.get(course)) {
                if (--indegree[next] == 0)
                    q.offer(next);
            }
        }

        return completed == numCourses;
    }
}
