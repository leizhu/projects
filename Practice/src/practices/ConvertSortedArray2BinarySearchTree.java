package practices;

import util.TreeNode;

public class ConvertSortedArray2BinarySearchTree {
	private TreeNode constructBST(int start, int end, int[] num){
        if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = constructBST(start, mid-1, num);
        root.right = constructBST(mid+1, end, num);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        int len = num.length;
        return constructBST(0,len-1,num);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
