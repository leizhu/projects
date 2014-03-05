package practices;

import util.ListNode;
//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p=l1, q=l2, head=null,tail=null;
        while(p!=null && q!=null){
            if(p.val < q.val){
                ListNode node = new ListNode(p.val);
                if(head==null){
                    head = node;
                    tail = head;
                }else{
                    tail.next = node;
                    tail = tail.next;
                }
                p = p.next;
            }else{
                ListNode node = new ListNode(q.val);
                if(head==null){
                    head = node;
                    tail = head;
                }else{
                    tail.next = node;
                    tail = tail.next;
                }
                q = q.next;
            }
        }
        while(p!=null){
            ListNode node = new ListNode(p.val);
            tail.next = node;
            tail = tail.next;
            p = p.next;
        }
        while(q!=null){
            ListNode node = new ListNode(q.val);
            tail.next = node;
            tail = tail.next;
            q = q.next;
        }
        return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		MergeTwoSortedLists test = new MergeTwoSortedLists();
		test.mergeTwoLists(l1, l2);
	}

}
