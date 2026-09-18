class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // adjacency list
        // for a course we complete, it unlocks 1 prerequisite for a list of courses
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<Integer>());
        }
        // indegree list
        // num er of prerequisites a course has left
        int[] indegree = new int[numCourses];


        // iterate through prerequisites to fill lists
        for (int i = 0; i < prerequisites.length; i++) {
            int[] set = prerequisites[i];
            int course = set[0];
            int prerequisite = set[1];

            // adjacency
            adjacency.get(prerequisite).add(course);
            // indegree
            indegree[course]++;
        }

        // bfs courses with no prerequisites
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // iterate through queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> validNow = adjacency.get(course);

            for (int valid : validNow) {
                indegree[valid]--;
                if (indegree[valid] == 0) {
                    queue.add(valid);
                }
            }
        }

        // check if all courses are done
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
