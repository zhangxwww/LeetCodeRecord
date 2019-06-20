
/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (36.15%)
 * Total Accepted:    284.8K
 * Total Submissions: 783.6K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 */
import java.util.Stack;

class MinStack {

    private Stack<Integer> common;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        common = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        common.push(x);
        if (minStack.empty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = common.pop();
        if (minStack.peek() == x) {
            minStack.pop();
        }
    }

    public int top() {
        return common.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
