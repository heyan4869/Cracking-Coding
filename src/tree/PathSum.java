package tree;

import java.util.ArrayList;

public class PathSum {
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
		int currSum = 0;
		ArrayList<Integer> currPath = new ArrayList<Integer>();
		
		// get all the node in the tree and check one by one
		ArrayList<TreeNode> a = new ArrayList<TreeNode>();
		a = helper(root, a);
		for (int i = 0; i < a.size(); i++) {
			TreeNode curr = a.get(i);
			getPath(curr, sum, currSum, currPath, path);
		}
		
		return path;
		
	}
	
	public static ArrayList<TreeNode> helper(TreeNode root, ArrayList<TreeNode> a) {
		if (root == null)
			return null;
		a.add(root);
		if (root.left != null)
			a = helper(root.left, a);
		if (root.right != null)
			a = helper(root.right, a);
		return a;
		
	}
	
	public static void getPath(TreeNode root, int sum, int currSum,
			ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> path) {
		if (root == null)
			return;
		// check if it is leaf node
		if (root.left == null && root.right == null) {
			if (root.val + currSum == sum) {
				ArrayList<Integer> extPath = new ArrayList<Integer>(currPath);
				extPath.add(root.val);
				path.add(extPath);
			}
		} else {
			int newSum = root.val + currSum;
			ArrayList<Integer> extPath = new ArrayList<Integer>(currPath);
			extPath.add(root.val);
			if (root.left != null)
				getPath(root.left, sum, newSum, extPath, path);
			if (root.right != null)
				getPath(root.right, sum, newSum, extPath, path);
		}
		
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(2);
		root.right.right.left = new TreeNode(14);
		//System.out.println(findPath(root, 16));
		ArrayList<ArrayList<Integer>> path = findPath(root, 16);
		System.out.println(path);
	}
}