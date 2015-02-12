// Given a sorted (increasing order) array with unique integer elements,
// write an algorithm to create a binary search tree with minimal height.
// Same problem in leetcode

package tree;

public class CreateBinaryTree {
	public TreeNode sortedArrayToBST(int[] num) {
    	TreeNode head = builder(num, 0, num.length - 1);
        return head;
        
    }

	public TreeNode builder(int[] num, int lowerBound, int higherBound) {
		if (lowerBound > higherBound)
			return null;
		int middle = (lowerBound + higherBound) / 2;
		TreeNode curr = new TreeNode(num[middle]);
		curr.left = builder(num, lowerBound, middle - 1);
		curr.right = builder(num, middle + 1, higherBound);
		return curr;
	}
}