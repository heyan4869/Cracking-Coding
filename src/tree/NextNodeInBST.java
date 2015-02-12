/*
Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in
a binary search tree. You may assume that each node has a link to its parent.
*/

package tree;


public class NextNodeInBST {
	public static TreeNode findNext(TreeNode target) {
		if (target == null)
			return null;
		if (target.right != null) {
			return findLeft(target.right);
		} else {
			TreeNode curr = target;
			TreeNode temp = curr.parent;
			while (temp != null && temp.left != curr) {
				curr = temp;
				temp = curr.parent;
			}
			return temp;
		}
	}
	
	
	public static TreeNode findLeft(TreeNode target) {
		if (target == null)
			return null;
		while (target.left != null) {
			target = target.left;
		}
		return target;
	}


	public static void main(String args[]) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(10);
		//root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		TreeNode next = findNext(root.left);
		
		//List<List<Integer>> result = helper(root);
		//System.out.println(root.right.val);
		System.out.println(next.val);
	
	}
}