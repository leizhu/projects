package practices;

import util.ListNode;

public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
        ListNode sortedHead=null, prev=null,tail=null;
        
        if(head==null) return null;
        
        while(head!=null){
          ListNode node = new ListNode(head.val);
          if(sortedHead==null){
              sortedHead = node;
              sortedHead.next = prev;
              tail = sortedHead;
          }else{
              while(tail!=null && tail.val<=node.val){
                  prev = tail;
                  tail = tail.next;
              }
              prev.next = node;
              node.next = tail;
              
              tail = sortedHead;
              prev = sortedHead;
          }
           
          head = head.next;
        }
        return sortedHead;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSortList test = new InsertionSortList();
		ListNode head = new ListNode(1);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(0);
		head.next = l1;
		l1.next = l2;
		test.insertionSortList(head);
	}

}
