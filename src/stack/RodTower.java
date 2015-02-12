//In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of
//different sizes which can slide onto any tower.The puzzle starts with disks 
//sorted in ascending order of size from top to bottom (e.g., each disk sits on 
//top of an even larger one).You have the following constraints:
//(A) Only one disk can be moved at a time.
//(B) A disk is slid off the top of one rod onto the next rod.
//(C) A disk can only be placed on top of a larger disk.
//Write a program to move the disks from the first rod to the last using Stacks.

package stack;

import java.util.Stack;

public class RodTower {
	
	public static Stack<Integer>[] towers = new Stack[3];
	
	public static void addDisk(int n) {
		for(int i=n; i>0; i--) {
			towers[0].push(i);
		}
		moveDisk(n, 0, 1, 2);
		
	}
	
	public static void moveDisk(int n, int i, int j, int k) {
		if(n>0) {
			moveDisk(n-1, i, k, j);
			int m = towers[i].pop();
			towers[k].push(m);
			moveDisk(n-1, j, i, k);
		}
		
	}

	public static void main(String args[]) {
		towers[0] = new Stack<Integer>();
		towers[1] = new Stack<Integer>();
		towers[2] = new Stack<Integer>();
		int n = 3; // this could be any integer based on specific problem
		addDisk(n);
		//check the result in the third stack
		while(!towers[2].empty()) {
			System.out.println(towers[2].pop());
		}
	}
}