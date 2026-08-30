class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // if there are still days waiting for warmer days
            if (stack.size() > 0) {
                // check if the temperature is warmer
                while (stack.size() > 0 && temperatures[i] > temperatures[stack.peek()]) {
                    // add to result
                    result[stack.peek()] = i - stack.peek();
                    // remove from waiting list
                    stack.pop();
                }
            }
            // add current day
            stack.push(i);
        }

        while (stack.size() > 0) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
