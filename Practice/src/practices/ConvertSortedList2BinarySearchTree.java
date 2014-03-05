package practices;

import util.*;

public class ConvertSortedList2BinarySearchTree {
	
	//TreeNode rootNode = null;
	
	private ListNode findNode(ListNode head, int index){
		ListNode p = head;
		for(int i=0; i<index; i++){
			p=p.next;
		}
		return p;
	}
	
	private TreeNode constructBST(int start, int end, ListNode linkHead){
		if(start>end) return null;
		int mid = (start+end)/2;
        ListNode p = findNode(linkHead,mid);
        TreeNode rootNode = new TreeNode(p.val);
        rootNode.left = constructBST(start,mid-1,linkHead);
        rootNode.right = constructBST(mid+1,end,linkHead);
        return rootNode;	    
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        // Get length of singly-linked list
        int len = 0;
        ListNode p=head;
        while(p!=null){
            len++;
            p = p.next;
        }
        
        TreeNode treeHead = constructBST(0,len-1,head);
        return treeHead;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertSortedList2BinarySearchTree test = new ConvertSortedList2BinarySearchTree();
		ListNode headListNode = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		headListNode.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		TreeNode treeHead = test.sortedListToBST(headListNode);
		System.out.println(treeHead);
	}

}
