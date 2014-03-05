package practices;

import java.util.ArrayList;

import util.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    int res ;
    public int sumNumbers(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
         if(root == null)
            return 0;
         res = 0;
         sumnum(root,0);
         return res;
    }
    public void sumnum(TreeNode root, int tmpsum)
    {
        if(root.left == null && root.right == null)
        {
            res += tmpsum * 10 + root.val;
        }
        if(root.left != null)
        {
            sumnum(root.left, tmpsum * 10 + root.val);
        }
        if(root.right != null)
        {
            sumnum(root.right, tmpsum * 10 + root.val);
        }        
    }
    
ArrayList<ArrayList<TreeNode> > possible_paths = new ArrayList<ArrayList<TreeNode> >();
    
    private int getInt(ArrayList<TreeNode> path){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<path.size(); i++){
            sb.append(path.get(i).val);
        }
        return Integer.parseInt(sb.toString());
    }
    
    private void printAllRootToLeafPaths(TreeNode node, ArrayList<TreeNode> path){
        if(node==null){
            return;
        }
        path.add(node);
        if(node.left==null && node.right==null){
            possible_paths.add(path);
            return;
        }else{
            printAllRootToLeafPaths(node.left, new ArrayList<TreeNode>(path));
            printAllRootToLeafPaths(node.right, new ArrayList<TreeNode>(path));
        }
    }
    
    public int sumNumbers2(TreeNode root) {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        printAllRootToLeafPaths(root, path);
        
        int sum=0;
        for(int i=0; i<possible_paths.size(); i++){
            sum += getInt(possible_paths.get(i));
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		SumRootToLeafNumbers test = new SumRootToLeafNumbers();
     	TreeNode rootNode = new TreeNode(0);
     	System.out.println(test.sumNumbers2(rootNode));
     	
     	int[][] m = new int[3][2];
     	System.out.println(m.length);
     	System.out.println(m[0].length);
     	
     	
	}
}