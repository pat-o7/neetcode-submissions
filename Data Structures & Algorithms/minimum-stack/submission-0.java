class MinStack {

    List<Integer> stack;
    List<Integer> mins;

    public MinStack() {
        stack = new ArrayList<>();
        mins = new ArrayList<>();
    }
    
    public void push(int val) {
        // add to stack
        stack.add(val);

        // add to mins
        if (stack.size() == 1) {
            mins.add(val);
        } else {
            // determine min
            int min = Math.min(mins.get(mins.size() - 1), val);
            // add to mins
            mins.add(min);
        }
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        mins.remove(mins.size() - 1);        
    }
    
    public int top() {
        return stack.get(stack.size() - 1);        
    }
    
    public int getMin() {
        return mins.get(mins.size() - 1);        
    }
}
