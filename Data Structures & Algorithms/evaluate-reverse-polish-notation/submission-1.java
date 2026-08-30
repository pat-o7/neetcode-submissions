class Solution {
    public int evalRPN(String[] tokens) {

        // stack
        Deque<Integer> stack = new ArrayDeque<>();

        // iterate through tokens
        for (int i = 0; i < tokens.length; i++) {
            // operand case
            if (tokens[i].equals("+") ||
                tokens[i].equals("-") ||
                tokens[i].equals("*") ||
                tokens[i].equals("/")) {
                int second = stack.pop();
                int first = stack.pop();

                int result;
                switch (tokens[i]) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    default:
                        result = first / second;
                }
                stack.push(result);
            } else {
                // integer case
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
