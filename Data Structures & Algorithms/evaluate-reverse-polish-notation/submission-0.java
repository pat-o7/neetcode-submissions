class Solution {
    public int evalRPN(String[] tokens) {

        // stack
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through tokens
        for (int i = 0; i < tokens.length; i++) {
            // operand case
            if (tokens[i].equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first + second;
                stack.push(result);
            } else if (tokens[i].equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first - second;
                stack.push(result);                
            } else if (tokens[i].equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first * second;
                stack.push(result);                
            } else if (tokens[i].equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int result = first / second;
                stack.push(result);                
            } else {
                // integer case
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
