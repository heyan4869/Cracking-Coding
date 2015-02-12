package tree;

public class BalanceTree {
	public boolean checkBalance(TreeNode root) {
		return checkHeight(root) != -1;
	}

	private int checkHeight(TreeNode root) {
		if (root==null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		int rightHeight = checkHeight(root.right);
		
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}