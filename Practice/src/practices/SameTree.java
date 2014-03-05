package practices;

import util.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null)
            return true;
        else if (p==null && q!=null)
            return false;
        else if (p!=null && q==null)
            return false;
        else {
            if (p.val != q.val)
                return false;
            else{
                if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right))
                    return true;
                else
                    return false;
            }
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
