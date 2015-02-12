/*
Design an algorithm and write code to find the first common ancestor of
two nodes in a binary tree. Avoidstoring additional nodes in a data structure.
NOTE: This is not necessarily a binary search tree.
*/

// Does the node has link to its parent?

package tree;

public class FindCommonAncestor {
	
	// assume the node has link to its parent
	public TreeNode findAncestor(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return null;
		TreeNode temp = a;
		while (temp.parent != null) {
			boolean flag = check(temp.parent, b);
			if (flag) {
				return temp.parent;
			} else {
				temp = temp.parent;
			}
		}
		return null;
	}

	public boolean check(TreeNode parent, TreeNode b) {
		if (parent == null)
			return false;
		if (parent.left == b || parent.right == b) {
			return true;
		} else {
			return check(parent.left, b) || check(parent.right, b);
			
		}
	}
}