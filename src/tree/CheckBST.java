// Implemen t a function to check if a binary tree is a binary search tree

/*
 * Binary search tree: Used for searching. A binary tree where the left child
 * contains only nodes with values less than the parent node, and where the 
 * right child only contains nodes with values greater than or equal to the parent.
 */
package tree;

import java.util.List;

public class CheckBST {
	public static boolean checkBST(TreeNode root) {
		return helper(root);
	}

	public static boolean helper(TreeNode root) {
		
		if(root == null) {
			return true;
		}
		if (root.left != null && root.left.val >= root.val) {
			return false;
		} else if (root.right != null && root.right.val < root.val) {
			return false;
		} else {
			boolean l = helper(root.left);
			boolean r = helper(root.right);
			if (l == false || r == false) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(12);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(23);
		//System.out.println(root.right.val);
		System.out.println(checkBST(root));
	
	}
}