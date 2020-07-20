package SystemDesign;

import java.util.Stack;

public class lc155 {
}

class MinStack {
    Stack<Integer>stack =new Stack<>();
    Stack<Integer>minStack=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())minStack.push(x);
        else if (minStack.peek()>=x)minStack.push(x);
    }

    public void pop() {
        int pop=stack.pop();
        if (pop==minStack.peek())minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
