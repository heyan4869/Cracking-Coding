package stack;

import java.util.Stack;

public class RodTowerNew {
	static class State {
		int num;
		String from;
		String assist;
		String to;
		boolean isSingleStep;
	}
	
	static Stack<State> move = new Stack<State>();
	
	
	public static void RodTower(int n) {
		// initialize the first state
		State s0 = new State();
		s0.num = n;
		s0.from = "one";
		s0.assist = "two";
		s0.to = "three";
		s0.isSingleStep = false;
		
		move.push(s0);
		
		State temp = move.peek();
		
		while(!move.isEmpty()) {
			temp = move.peek();
			
			move.pop();
			if (temp.isSingleStep || temp.num == 1) {
				System.out.println("move " + temp.num + " from " + temp.from + " to " + temp.to);
				
			} else {
				State s1 = new State();
				State s2 = new State();
				State s3 = new State();
				
				s1.num = temp.num - 1;
				s1.from = temp.assist;
				s1.assist = temp.from;
				s1.to = temp.to;
				s1.isSingleStep = false;
				move.push(s1);
				
				s2.num = temp.num;
				s2.from = temp.from;
				s2.assist = temp.assist;
				s2.to = temp.to;
				s2.isSingleStep = true;
				move.push(s2);
				
				s3.num = temp.num - 1;
				s3.from = temp.from;
				s3.assist = temp.to;
				s3.to = temp.assist;
				s3.isSingleStep = false;
				move.push(s3);
			}
			
		}
		
	}
	
	public static void main(String args[]) {
		int n = 3;
		RodTower(n);
	}
}
