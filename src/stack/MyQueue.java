package stack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> stack1, stack2;
	
	public MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void add(int val) {
		stack1.push(val);
	}
	
	public int peek() {
		transfer();
		return stack2.peek();
	}
	
	private void transfer() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}
	
	public int remove() {
		transfer();
		return stack2.pop();
	}
}