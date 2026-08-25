class Solution {
    public boolean isValid(String s) {

        char[] brackets = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                System.out.println("in push");
                stack.push(bracket);
                System.out.println("stack size: " + stack.size());
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (bracket == ')' && stack.peek() != '(') {
                    return false;
                }
                if (bracket == ']' && stack.peek() != '[') {
                    return false;
                }
                if (bracket == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();                            
                
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
