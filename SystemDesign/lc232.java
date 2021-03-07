package SystemDesign;

import java.util.Stack;

public class lc232 {
    class MyQueue {
        Stack<Integer>pushStack;
        Stack<Integer>popStack;
        /** Initialize your data structure here. */
        public MyQueue() {
            this.popStack=new Stack<>();
            this.pushStack=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (popStack.empty()){
                while (!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
                return popStack.pop();
            }
            else {
                return popStack.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            if (popStack.empty()){
                while (!pushStack.empty()){
                    popStack.push(pushStack.pop());
                }
                return popStack.peek();
            }
            else {
                return popStack.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return popStack.empty()&& pushStack.empty();
        }
    }
}
