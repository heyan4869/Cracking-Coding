package tree;

import java.util.ArrayList;
import java.util.List;

// not finish yet
public class AllPath {
	public static ArrayList<List<Integer>> findPath(TreeNode root) {
		if (root == null)
			return null;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		
		return null;
	}
	
	public static ArrayList<List<Integer>> getPath(TreeNode node) {
		List<Integer> path = new ArrayList<Integer>();
		path.add(node.val);
		
		
		
		return null;
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
		System.out.println(findPath(root));
	}
}