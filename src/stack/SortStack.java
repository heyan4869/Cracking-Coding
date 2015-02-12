// Write a program to sort a stack in ascending order (with biggest 
// items on top). You may use at most one additional stack to hold items,
// but you may not copy the elements into any other data structures (such
// as an array). The stack supports the following operations: push, pop, 
// peek, and isEmpty.

package stack;

import java.util.Stack;

public class SortStack {
	public Stack<Integer> sort(Stack<Integer> s) {
		if(s.isEmpty())
			return null;
		Stack<Integer> assist = new Stack<Integer>();
		while(!s.isEmpty()) {
			int candidate = s.pop();
			while(!assist.isEmpty() && assist.peek()>candidate) {
				s.push(assist.pop());
			}
			assist.push(candidate);
		}
		
		return assist;
	}
}