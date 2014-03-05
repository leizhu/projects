package practices;

import util.*;

public class MaximumDepthofBinaryTree {
	private int max(int a, int b) {
        return a>b ? a: b;
    }
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left!=null && root.right!=null)
            return 1+max(maxDepth(root.left), maxDepth(root.right));
        else if(root.left!=null && root.right==null) 
            return 1+maxDepth(root.left);
        else if(root.left==null && root.right!=null) 
            return 1+maxDepth(root.right);
        else
            return 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
