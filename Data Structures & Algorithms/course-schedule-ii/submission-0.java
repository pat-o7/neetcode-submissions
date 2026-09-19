class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

        // adjacency list
        // for this course, it is prerequisite to this list of courses
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // indegree list
        // how many prerequisites are left for a course
        int[] indegree = new int[numCourses];

        // initialize lists
        for (int i = 0; i < prerequisites.length; i++) {
            int[] dependency = prerequisites[i];
            int course = dependency[0];
            int prerequisite = dependency[1];

            // adjacency
            adjacency.get(prerequisite).add(course);
            // indegree
            indegree[course]++;
        }

        // initialize queue
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            // a course with no prerequisites left that we can now take
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // BFS
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            // add to reslut
            result[resultIndex] = current;
            resultIndex++;
            // what does this course unlock?
            List<Integer> unlocks = adjacency.get(current);

            for (int course : unlocks) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) {
                return new int[]{};
            }
        }

        return result;
    }
}
