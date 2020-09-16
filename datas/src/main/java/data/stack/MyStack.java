package data.stack;

import java.util.LinkedList;

class MyStack {

    public LinkedList<Integer> q1 = new LinkedList<Integer>();
    public LinkedList<Integer> q2 = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //在q2中push到底部
        q2.push(x);
        //q1全部push到q2
        while(!q1.isEmpty()){
            q2.push(q1.remove());
        }
        //q2和q2交换
        LinkedList<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
