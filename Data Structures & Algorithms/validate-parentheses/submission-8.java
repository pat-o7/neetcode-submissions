class Solution {
    public boolean isValid(String s) {
        char[] sChar = s.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '[' || sChar[i] == '(' || sChar[i] == '{') {
                stack.push(sChar[i]);
            } else {
                if (((stack.size() > 0 && sChar[i] == ']' && stack.peek() == '[')) ||
                ((stack.size() > 0 && sChar[i] == ')' && stack.peek() == '(')) ||
                ((stack.size() > 0 && sChar[i] == '}' && stack.peek() == '{')))
                 {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
