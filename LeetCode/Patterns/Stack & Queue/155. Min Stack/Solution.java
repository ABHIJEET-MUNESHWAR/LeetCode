class MinStack {

  Stack<Integer> stack;
  Queue<Integer> queue;

  public MinStack() {
    stack = new Stack<>();
    queue = new PriorityQueue<>();
  }
    
public void push(int val) {
    stack.push(val);
    queue.add(val);
  }

  public void pop() {
    int element = stack.pop();
    queue.remove(element);
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return queue.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */