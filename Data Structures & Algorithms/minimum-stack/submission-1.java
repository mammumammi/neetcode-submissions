class MinStack {
    List<Integer> stack;
    int max;
    int minVal;
    public MinStack() {
        stack = new ArrayList<>();
        max = 0;
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.add(val);
        max++;
    }
    
    public void pop() {
        if (max -1 < 0) return;
        stack.remove(max -1);
        max--;
    }
    
    public int top() {
        if (max - 1 < 0) return 0;
        return stack.get(max -1);
    }
    
    public int getMin() {
        minVal = Integer.MAX_VALUE;
        for (int i = 0;i<max;i++){
            minVal = Math.min(minVal,stack.get(i));
        }
        return minVal;
    }
}
