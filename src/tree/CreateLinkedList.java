// Given a binary tree, design an algorithm which creates a linked 
// list of all the nodes at each depth (e.g., if you have a tree 
// with depth D, you'll have D linked lists).

// Queue is an interface in java, try Queue<Integer> Q = new LinkedList<Integer>(); 

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class CreateLinkedList {
	
	//create a new class for storing the detail information of each node in the tree
	class NodeState {
		TreeNode node;
		String state;
		int level;
	}
			
	public ArrayList<LinkedList> create(TreeNode head) {
		// check the head node first
		if(head==null)
			return null;
		
		// initial a stack for storing the node
		Stack<NodeState> s = new Stack<NodeState>();
		//Stack<NodeState> s2 = new Stack<NodeState>();
		
		// initial a integer for keeping the level
		int num = 0;
		
		// push the head node in stack
		s = addNode(s, head, num);
		
		// initial a ArrayList that stores all the LinkedList
		ArrayList<LinkedList> a = new ArrayList<LinkedList>();
		
		// store all the LinkedList in a
		NodeState deepest = s.peek();
		int height = deepest.level;
		for (int i = height; i > 0; i--) {
			LinkedList<NodeState> l = new LinkedList<NodeState>();
			while (!s.isEmpty()) {
				NodeState curr = s.peek();
				if (curr.level == i) {
					curr = s.pop();
					l.add(curr);
				} else {
					a.add(l);
					continue;
				}
			}
		}
				
		return a;
	}

	// recursively push all the nodes in this tree into stack s
	public Stack<NodeState> addNode(Stack<NodeState> s, TreeNode head, int num) {
		// check if the head node is null
		if(head==null)
			return null;
		
		// set up the parameter for the node
		NodeState n = new NodeState();
		n.node = head;
		n.state = "visited";
		n.level = num++;
		
		// add the node into stack
		s.push(n);
		
		//add the two children of the node into the stack
		addNode(s, n.node.left, n.level);
		addNode(s, n.node.right, n.level);
		
		return s;
	}
}
