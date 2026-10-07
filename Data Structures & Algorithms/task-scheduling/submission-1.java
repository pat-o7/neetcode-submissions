class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;

        // frequency map of tasks
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }

        // max heap of tasks
        Queue<Character> heap = new PriorityQueue<>((a, b) -> {
            if (map.get(a) > map.get(b)) {
                return -1;
            } else if (map.get(a) < map.get(b)) {
                return +1;
            } else {
                return 0;
            }
        });
        for (Character task : map.keySet()) {
            heap.add(task);
        }

        // cooldown queue of tasks
        Deque<CooldownTask> cooldowns = new ArrayDeque<>();

        // while heap is not empty
        // poll next task to execute
        // check cooldown queue for available tasks
        while (!heap.isEmpty() || !cooldowns.isEmpty()) {

            // check cooldown tasks
            while (!cooldowns.isEmpty() && cooldowns.peek().availableTime <= time) {
                heap.add(cooldowns.poll().task);
            }

            // execute next task
            if (!heap.isEmpty()) {
                char currentTask = heap.poll();
                map.put(currentTask, map.get(currentTask) - 1);
                time++;
                if (map.get(currentTask) > 0) {
                    cooldowns.offer(new CooldownTask(currentTask, time + n));
                }
            } else {
                time++;
            }
        }
        return time;
    }
}

class CooldownTask {
    public char task;
    public int availableTime;

    public CooldownTask(char task, int availableTime) {
        this.task = task;
        this.availableTime = availableTime;
    }
}
