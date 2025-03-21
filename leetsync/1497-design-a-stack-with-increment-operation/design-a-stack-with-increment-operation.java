class CustomStack {
    int currentPointer;
    int[] stack;
    int n;

    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new int[n];
        currentPointer = -1;
    }

    public void push(int x) {
        if (currentPointer >= n-1) {
            return;
        }
        currentPointer++;
        stack[currentPointer] = x;        
    }

    public int pop() {
        if (currentPointer < 0) {
            return -1;
        }
        int element = stack[currentPointer];        
        currentPointer--;
        return element;
    }

    public void increment(int k, int val) {
        int upperLimit = Math.min(k, n);
        for (int i = 0; i < upperLimit; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */