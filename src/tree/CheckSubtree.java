package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckSubtree {
	public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		
		return findNode(t1, t2);
	}
	
	public static boolean findNode(TreeNode t1, TreeNode t2) {
		if (t1 == null) 
			return false;
		if (t1.val == t2.val)
			return checkIfSame(t1, t2);
		else
			return (findNode(t1.left, t2) || findNode(t1.right, t2));
	}

	public static boolean checkIfSame(TreeNode t1, TreeNode t2) {
		List<Integer> l1 = inOrderTrav(t1);
		List<Integer> l2 = inOrderTrav(t2);
		if (l1.equals(l2))
			return true;
		else
			return false;
	}

	private static List<Integer> inOrderTrav(TreeNode n) {
		if (n == null)
			return null;
		
		List<Integer> trav = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode temp = n;
		s.push(temp);
		
		while (!s.isEmpty() || temp != null) {
			while (temp.left != null) {
				s.push(temp.left);
				temp = temp.left;
			}
			
			temp = s.pop();
			trav.add(temp.val);
			temp = temp.right;
		}
		
		return trav;
	}
}